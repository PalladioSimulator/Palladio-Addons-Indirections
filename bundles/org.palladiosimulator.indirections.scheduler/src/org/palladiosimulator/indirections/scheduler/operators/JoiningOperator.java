package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Predicate;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.data.DataWithSource;
import org.palladiosimulator.indirections.scheduler.data.JoinedDate;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.indirections.util.StreamUtil;

public class JoiningOperator<T extends IndirectionDate> extends SimStatefulOperator<DataWithSource<T>, JoinedDate<T>> {
    private final Iterable<JoiningOperator.Channel<DataWithSource<T>>> channels;

    public static abstract class Channel<U> {
        public final Queue<U> data;
        public final boolean retainData;

        public Channel(boolean retainData) {
            this.data = new ArrayDeque<>();
            this.retainData = retainData;
        }

        public void put(U date) {
            if (!retainData)
                data.clear();
            data.add(date);
        }

        public boolean canProvide() {
            return !data.isEmpty();
        }

        public U get() {
            return retainData ? data.remove() : data.element();
        }

        public abstract boolean isResponsibleFor(U date);
    }

    public static class StrategyChannel<U> extends Channel<U> {
        private final Predicate<U> isResponsibleFor;

        public StrategyChannel(boolean retainData, Predicate<U> isResponsibleFor) {
            super(retainData);
            this.isResponsibleFor = isResponsibleFor;
        }

        @Override
        public boolean isResponsibleFor(U date) {
            return isResponsibleFor.test(date);
        }

    }

    public JoiningOperator(Iterable<Channel<DataWithSource<T>>> channels) {
        this.channels = channels;
    }

    public static <U extends IndirectionDate> JoiningOperator<U> createWithIndices(
            Function<DataWithSource<U>, Integer> dateToClass, List<Boolean> retainDataArray) {

        List<Channel<DataWithSource<U>>> channels = new ArrayList<>();
        for (int i = 0; i < retainDataArray.size(); i++) {
            boolean retainData = retainDataArray.get(i);
            final int indexToCheck = i;
            channels.add(new StrategyChannel<DataWithSource<U>>(retainData,
                    (date) -> dateToClass.apply(date) == indexToCheck));
        }

        return new JoiningOperator<>(channels);
    }

    @Override
    public void accept(DataWithSource<T> date) {
        Channel<DataWithSource<T>> channelToAddTo = IterableUtil.stream(channels)
                .filter(it -> it.isResponsibleFor(date)).reduce(StreamUtil.reduceToMaximumOne()).get();
        channelToAddTo.data.add(date);

        // if all retain, we do not iterate until one cannot provide anymore
        boolean allRetain = IterableUtil.stream(channels).allMatch(it -> it.retainData);

        while (IterableUtil.stream(channels).allMatch(Channel::canProvide)) {
            Map<Channel<DataWithSource<T>>, T> dataMap = new HashMap<>();
            for (Channel<DataWithSource<T>> channel : channels) {
                dataMap.put(channel, channel.get().date);
            }
            emit(new JoinedDate<T>(dataMap));

            if (allRetain)
                break;
        }
    }

}