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

public class JoiningOperator<T extends IndirectionDate> extends SimStatefulOperator<DateWithConnector<T>, JoinedDate<T>> {
    private final Iterable<JoiningOperator.KeyedChannel<DateWithConnector<T>, Object>> channels;

    public static abstract class Channel<U> {
        public final Queue<U> data;
        public final boolean retainData;

        public Channel(boolean retainData) {
            this.data = new ArrayDeque<>();
            this.retainData = retainData;
        }

        public void put(U date) {
            if (retainData)
                data.clear();
            data.add(date);
        }

        public boolean canProvide() {
            return !data.isEmpty();
        }

        public U get() {
            return retainData ? data.element() : data.remove();
        }

        public abstract boolean isResponsibleFor(U date);
    }

    public static abstract class KeyedChannel<U, K> {
        public final List<U> data;
        public final boolean retainData;
        public final Function<U, K> keyFunction;

        public KeyedChannel(boolean retainData, Function<U, K> keyFunction) {
            this.data = new ArrayList<>();
            this.retainData = retainData;
            this.keyFunction = keyFunction;
        }

        public void put(U date) {
            if (retainData)
                data.clear();
            data.add(date);
        }

        public boolean canProvide(K key) {
            return data.stream().anyMatch(it -> keyFunction.apply(it).equals(key));
        }

        public U get(K key) {
            U result = null;
            int i = 0;

            for (U u : data) {
                if (keyFunction.apply(u).equals(key)) {
                    result = u;
                    if (!retainData)
                        data.remove(i);
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
    }

    public static class StrategyChannel<U, K> extends KeyedChannel<U, K> {
        private final Predicate<U> isResponsibleFor;

        public StrategyChannel(boolean retainData, Function<U, K> keyFunction, Predicate<U> isResponsibleFor) {
            super(retainData, keyFunction);
            this.isResponsibleFor = isResponsibleFor;
        }

        @Override
        public boolean isResponsibleFor(U date) {
            return isResponsibleFor.test(date);
        }

    }

    public JoiningOperator(Iterable<KeyedChannel<DateWithConnector<T>, Object>> channels) {
        this.channels = channels;
    }

    public static <U extends IndirectionDate> JoiningOperator<U> createWithIndices(
            Function<DateWithConnector<U>, Integer> dateToClass, List<PCMRandomVariable> joinKeys,
            List<Boolean> retainDataArray) {

        List<KeyedChannel<DateWithConnector<U>, Object>> channels = new ArrayList<>();
        for (int i = 0; i < retainDataArray.size(); i++) {
            boolean retainData = retainDataArray.get(i);
            final int indexToCheck = i;
            channels.add(new StrategyChannel<DateWithConnector<U>, Object>(retainData,
                    (date) -> date.date.evaluate(joinKeys.get(indexToCheck)),
                    (date) -> dateToClass.apply(date) == indexToCheck));
        }

        return new JoiningOperator<>(channels);
    }

    @Override
    public void accept(DateWithConnector<T> date) {
        KeyedChannel<DateWithConnector<T>, Object> channelToAddTo = IterableUtil.stream(channels)
                .filter(it -> it.isResponsibleFor(date)).reduce(StreamUtil.reduceToMaximumOne()).get();
        channelToAddTo.put(date);
		DataSourceSinkConnector source = date.source;

        Object key = channelToAddTo.keyFunction.apply(date);

        // if all retain, we do not iterate until one cannot provide anymore
        boolean allRetain = IterableUtil.stream(channels).allMatch(it -> it.retainData);

        while (IterableUtil.stream(channels).allMatch(it -> it.canProvide(key))) {
            Map<KeyedChannel<DateWithConnector<T>, Object>, T> dataMap = new HashMap<>();
            for (KeyedChannel<DateWithConnector<T>, Object> channel : channels) {
                dataMap.put(channel, channel.get(key).date);
            }
            emit(new JoinedDate<T>(dataMap));

            if (allRetain)
                break;
        }
    }
}