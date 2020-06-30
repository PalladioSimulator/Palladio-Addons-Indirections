package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Predicate;

import org.palladiosimulator.indirections.composition.abstract_.DataSourceSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.DateWithConnector;
import org.palladiosimulator.indirections.scheduler.data.JoinedDate;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.indirections.util.StreamUtil;
import org.palladiosimulator.pcm.core.PCMRandomVariable;

public class JoiningOperator<T extends IndirectionDate>
        extends SimStatefulOperator<DateWithConnector<T>, JoinedDate<T>> {
    public static abstract class Channel<U> {
        public final Queue<U> data;
        public final boolean retainData;

        public Channel(final boolean retainData) {
            this.data = new ArrayDeque<>();
            this.retainData = retainData;
        }

        public boolean canProvide() {
            return !this.data.isEmpty();
        }

        public U get() {
            return this.retainData ? this.data.element() : this.data.remove();
        }

        public abstract boolean isResponsibleFor(U date);

        public void put(final U date) {
            if (this.retainData) {
                this.data.clear();
            }
            this.data.add(date);
        }
    }

    public static abstract class KeyedChannel<U, K> {
        public final List<U> data;
        public final Function<U, K> keyFunction;
        public final boolean retainData;

        public KeyedChannel(final boolean retainData, final Function<U, K> keyFunction) {
            this.data = new ArrayList<>();
            this.retainData = retainData;
            this.keyFunction = keyFunction;
        }

        public boolean canProvide(final K key) {
            return this.data.stream()
                .anyMatch(it -> this.keyFunction.apply(it)
                    .equals(key));
        }

        public U get(final K key) {
            U result = null;
            int i = 0;

            for (final U u : this.data) {
                if (this.keyFunction.apply(u)
                    .equals(key)) {
                    result = u;
                    if (!this.retainData) {
                        this.data.remove(i);
                    }
                    break;
                }
                i++;
            }

            if (result == null) {
                throw new NoSuchElementException("No element for key " + key + " could be found in channel.");
            }
            return result;
        }

        public abstract boolean isResponsibleFor(U date);

        public void put(final U date) {
            if (this.retainData) {
                this.data.clear();
            }
            this.data.add(date);
        }
    }

    public static class StrategyChannel<U, K> extends KeyedChannel<U, K> {
        private final Predicate<U> isResponsibleFor;

        public StrategyChannel(final boolean retainData, final Function<U, K> keyFunction,
                final Predicate<U> isResponsibleFor) {
            super(retainData, keyFunction);
            this.isResponsibleFor = isResponsibleFor;
        }

        @Override
        public boolean isResponsibleFor(final U date) {
            return this.isResponsibleFor.test(date);
        }

    }

    public static <U extends IndirectionDate> JoiningOperator<U> createWithIndices(
            final Function<DateWithConnector<U>, Integer> dateToClass, final List<PCMRandomVariable> joinKeys,
            final List<Boolean> retainDataArray) {

        final List<KeyedChannel<DateWithConnector<U>, Object>> channels = new ArrayList<>();
        for (int i = 0; i < retainDataArray.size(); i++) {
            final boolean retainData = retainDataArray.get(i);
            final int indexToCheck = i;
            channels.add(new StrategyChannel<DateWithConnector<U>, Object>(retainData,
                    (date) -> date.date.evaluate(joinKeys.get(indexToCheck)),
                    (date) -> dateToClass.apply(date) == indexToCheck));
        }

        return new JoiningOperator<>(channels);
    }

    private final Iterable<JoiningOperator.KeyedChannel<DateWithConnector<T>, Object>> channels;

    public JoiningOperator(final Iterable<KeyedChannel<DateWithConnector<T>, Object>> channels) {
        this.channels = channels;
    }

    @Override
    public void accept(final DateWithConnector<T> date) {
        final KeyedChannel<DateWithConnector<T>, Object> channelToAddTo = IterableUtil.stream(this.channels)
            .filter(it -> it.isResponsibleFor(date))
            .reduce(StreamUtil.reduceToMaximumOne())
            .get();
        channelToAddTo.put(date);
        final DataSourceSinkConnector source = date.source;

        final Object key = channelToAddTo.keyFunction.apply(date);

        // if all retain, we do not iterate until one cannot provide anymore
        final boolean allRetain = IterableUtil.stream(this.channels)
            .allMatch(it -> it.retainData);

        while (IterableUtil.stream(this.channels)
            .allMatch(it -> it.canProvide(key))) {
            final Map<KeyedChannel<DateWithConnector<T>, Object>, T> dataMap = new HashMap<>();
            for (final KeyedChannel<DateWithConnector<T>, Object> channel : this.channels) {
                dataMap.put(channel, channel.get(key).date);
            }
            this.emit(new JoinedDate<T>(dataMap));

            if (allRetain) {
                break;
            }
        }
    }
}