package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Function;
import org.palladiosimulator.indirections.util.IterableUtil;

public final class Emitters {
	public static interface StatefulEmitter<T, U> {
		public Optional<U> accept(T t);
	}
	
	// R: type of the key to check equality with
	public static class EqualityCollectorWithHoldback<T, R> implements StatefulEmitter<T, List<T>> {
		// length of this collection is always <= n. holdback 1 means that if a new element arrives
		// the old collection is emitted. for holdback 2, a collection is only emitted, after 2 new (distinct)
		// elements have been seen.
		
		
		public Queue<List<T>> currentCollections = new ArrayDeque<List<T>>();
		private final int holdback;
		private final Function<T, R> keyFunction;
		
		
		public EqualityCollectorWithHoldback(Function<T, R> keyFunction, int holdback) {
			this.keyFunction = keyFunction;
			this.holdback = holdback;
		}
		
		@Override
		public Optional<List<T>> accept(T t) {
			for (List<T> collection : currentCollections) {
				R collectionKey = IterableUtil.claimEqualKey(collection, keyFunction);
				if (collectionKey.equals(keyFunction.apply(t))) {
					collection.add(t);
					return Optional.empty();
				}
			}

			List<T> newCollection = new ArrayList<T>();
			newCollection.add(t);
			currentCollections.add(newCollection);
			
			if (currentCollections.size() > holdback) {
				return Optional.of(currentCollections.remove());
			}
			
			return Optional.empty();
		}
	}
	
	public static class WindowCalculator {
		public double size;
		public double shift;

		public Window currentWindow;
		public Window emittedWindow;

		public WindowCalculator(double size, double shift) {
			super();
			this.size = size;
			this.shift = shift;
		}

		public Window next() {
			currentWindow = createNextWindow();
			return currentWindow;
		}

		public Window createNextWindow() {
			if (currentWindow == null)
				return new Window(0, size);
			else
				return new Window(currentWindow.start + shift, currentWindow.start + shift + size);
		}

		public List<Window> advanceUntil(double currentSimulationTime) {
			List<Window> result = new ArrayList<>();
			while (currentSimulationTime >= createNextWindow().end) {
				result.add(next());
			}
			return result;
		}
	}
	
	public static class WindowEmitter implements StatefulEmitter<Double, List<Window>> {
		private final WindowCalculator windowCalculator;

		public WindowEmitter(double size, double shift) {
			this.windowCalculator = new WindowCalculator(size, shift);
		}
		
		@Override
		public Optional<List<Window>> accept(Double t) {
			List<Window> windows = windowCalculator.advanceUntil(t);
			return windows.isEmpty() ? Optional.empty() : Optional.of(windows);
		}
		
	}

	public static class Window {
		public final double start;
		public final double end;

		public Window(double start, double end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "W[" + start + "->" + end + "]";
		}

		public boolean contains(double timestamp) {
			return (start <= timestamp) && (end > timestamp);
		}
	}
}