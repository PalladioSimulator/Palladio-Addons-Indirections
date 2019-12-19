package org.palladiosimulator.indirections.scheduler.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Function;

import org.palladiosimulator.indirections.scheduler.operators.Emitters.EqualityCollectorWithHoldback.HeldBackList;
import org.palladiosimulator.indirections.util.IterableUtil;

public final class Emitters {
    public static interface StatefulEmitter<T, U> {
        public Optional<U> accept(T t);
    }

    // R: type of the key to check equality with
    public static class EqualityCollectorWithHoldback<T, R> implements StatefulEmitter<T, HeldBackList<R, T>> {
        // length of this collection is always <= n. holdback 1 means that if a new element arrives
        // the old collection is emitted. for holdback 2, a collection is only emitted, after 2 new
        // (distinct)
        // elements have been seen.

        public static class HeldBackList<R, T> {
            public R key;
            public List<T> list;

            public HeldBackList(R key, List<T> list) {
                this.key = key;
                this.list = list;
            }
        }

        public Queue<HeldBackList<R, T>> currentCollections = new ArrayDeque<HeldBackList<R, T>>();
        private final int holdback;
        private final Function<T, R> keyFunction;

        public EqualityCollectorWithHoldback(final Function<T, R> keyFunction, final int holdback) {
            this.keyFunction = keyFunction;
            this.holdback = holdback;
        }

        @Override
        public Optional<HeldBackList<R, T>> accept(final T t) {
            R key = this.keyFunction.apply(t);
            for (final HeldBackList<R, T> collection : this.currentCollections) {
                final R collectionKey = IterableUtil.claimEqualKey(collection.list, this.keyFunction);
                if (collectionKey.equals(key)) {
                    collection.list.add(t);
                    return Optional.empty();
                }
            }

            final HeldBackList<R, T> newList = new HeldBackList<>(key, new ArrayList<>());
            newList.list.add(t);
            this.currentCollections.add(newList);

            if (this.currentCollections.size() > this.holdback) {
                return Optional.of(this.currentCollections.remove());
            }

            return Optional.empty();
        }
    }

    public static class WindowCalculator {
        public double size;
        public double shift;

        public Window currentWindow;
        public Window emittedWindow;

        public WindowCalculator(final double size, final double shift) {
            super();
            this.size = size;
            this.shift = shift;
        }

        public Window next() {
            this.currentWindow = this.createNextWindow();
            return this.currentWindow;
        }

        public Window createNextWindow() {
            if (this.currentWindow == null) {
                return new Window(this.shift - this.size, this.shift);
            } else {
                return new Window(this.currentWindow.start + this.shift,
                        this.currentWindow.start + this.shift + this.size);
            }
        }

        public boolean isInCurrentWindow(final double time) {
            return currentWindow.contains(time);
        }

        public List<Window> advanceUntil(final double currentSimulationTime) {
            final List<Window> result = new ArrayList<>();
            while (currentSimulationTime >= this.createNextWindow().end) {
                result.add(this.next());
            }
            return result;
        }
    }

    public static class WindowEmitter implements StatefulEmitter<Double, List<Window>> {
        private final WindowCalculator windowCalculator;

        public WindowEmitter(final double size, final double shift) {
            this.windowCalculator = new WindowCalculator(size, shift);
        }

        @Override
        public Optional<List<Window>> accept(final Double t) {
            final List<Window> windows = this.windowCalculator.advanceUntil(t);
            return windows.isEmpty() ? Optional.empty() : Optional.of(windows);
        }

    }

    public static class Window {
        public final double start;
        public final double end;

        public Window(final double start, final double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "W[" + this.start + "->" + this.end + "]";
        }

        public boolean contains(final double timestamp) {
            return (this.start <= timestamp) && (this.end > timestamp);
        }
    }
}