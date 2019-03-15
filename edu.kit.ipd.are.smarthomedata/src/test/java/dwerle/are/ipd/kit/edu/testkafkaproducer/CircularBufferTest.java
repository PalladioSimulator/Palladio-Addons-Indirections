package dwerle.are.ipd.kit.edu.testkafkaproducer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.kit.ipd.are.smarthomedata.datastructures.CircularBuffer;

class CircularBufferTest {
	@Test
	void testSingles0() {
		doTest(1,
				new int[] { 1 },
				new float[] { 1f },
				1, 1, 1f);
	}
	
	@Test
	void testSingles1() {
		doTest(2,
				new int[] { 1 },
				new float[] { 1f },
				1, 1, 1f);
	}
	
	@Test
	void testSinglesInvalidWindow() {
		assertThrows(IllegalStateException.class, () -> {
		doTest(1,
				new int[] { 1, 2 },
				new float[] { 1f, 2f },
				1, 1, Float.NaN);
		});
	}
	
	@Test
	void testSingles2() {
		doTest(2,
				new int[] { 1, 2 },
				new float[] { 1f, 2f },
				1, 1, 1f);
		doTest(2,
				new int[] { 1, 2 },
				new float[] { 1f, 2f },
				2, 2, 2f);
	}
	
	@Test
	void testSinglesCircular() {
		doTest(5,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				5, 5, 5f);
		
		doTest(4,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				4, 4, 4f);
		
		doTest(3,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				4, 4, 4f);
		
		doTest(2,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				5, 5, 5f);
	}
	
	@Test
	void testEachSortedEven() {
		doTest(10,
				new int[] { 1, 2, 3, 4, 5, 6 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f },
				1, 6, 3.5f);
	}

	@Test
	void testEachSortedOdd() {
		doTest(10,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				1, 5, 3f);
	}
	
	@Test
	void testEachSortedEvenSubset0() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				1, 6, 3.5f);
	}
	
	@Test
	void testEachSortedEvenSubset1() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				2, 7, 4.5f);
	}
	
	@Test
	void testEachSortedEvenSubset2() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				3, 8, 5.5f);
	}
	
	@Test
	void testEachSortedOddSubset0() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				1, 5, 3f);
	}
	
	@Test
	void testEachSortedOddSubset1() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				2, 6, 4f);
	}
	
	@Test
	void testEachSortedOddSubset2() {
		doTest(12,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f },
				3, 7, 5f);
	}

	@Test
	void testEachReversedEven() {
		doTest(10,
				new int[] { 1, 2, 3, 4, 5, 6 },
				new float[] { 6f, 5f, 4f, 3f, 2f, 1f },
				1, 6, 3.5f);
	}

	@Test
	void testEachReversedOdd() {
		doTest(10,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 5f, 4f, 3f, 2f, 1f },
				1, 5, 3f);
	}

	@Test
	void testSkipSortedOdd1() {
		doTest(10,
				new int[] { 1, 3, 6 },
				new float[] { 1f, 2f, 3f },
				1, 6, 2f);
	}
	
	@Test
	void testSkipSortedOdd2() {
		doTest(10,
				new int[] { 1, 3, 5 },
				new float[] { 1f, 2f, 3f },
				1, 6, 2f);
	}
	
	@Test
	void testSkipSortedOdd3() {
		/*
		 *  1     2     3     4     5     6
		 * 1 - 1 - 2 - 3 - 3 - 3
		 *              \_____/ 
		 */
		doTest(10,
				new int[] { 1, 3, 4 },
				new float[] { 1f, 2f, 3f },
				1, 6, 2.5f);
	}
	
	@Test
	void testSkipSortedEven1() {
		/*
		 *  1     2     3     4     5     6     7
		 * 1 - 1 - 2 - 3 - 3 - 3 - 3
		 */
		doTest(10,
				new int[] { 1, 3, 4 },
				new float[] { 1f, 2f, 3f },
				1, 7, 3f);
	}
	
	@Test
	void testSkipSortedEven2() {
		/*
		 *  1     2     3     4     5     6     7
		 * 1 - 1 - 2 - 2 - 3 - 3 - 3
		 */
		doTest(10,
				new int[] { 1, 3, 5 },
				new float[] { 1f, 2f, 3f },
				1, 7, 2f);
	}
	
	@Test
	void testSkipLateStart() {
		/*
		 *  2     3     4     5     6     7
		 * 1 - 2 - 2 - 3 - 3 - 3
		 */
		doTest(10,
				new int[] { 1, 3, 5 },
				new float[] { 1f, 2f, 3f },
				2, 7, 2.5f);
	}
	
	@Test
	void testCircularEach0() {
		doTest(4,
				new int[] { 1, 2, 3, 4 },
				new float[] { 1f, 2f, 3f, 4f },
				1, 4, 2.5f);
	}
	
	@Test
	void testCircularEach1() {
		doTest(4,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				2, 5, 3.5f);
	}
	
	@Test
	void testCircularEach4() {
		doTest(4,
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f },
				5, 8, 6.5f);
	}
	
	@Test
	void testCircularOdd0() {
		doTest(5,
				new int[] { 1, 2, 3, 4, 5 },
				new float[] { 1f, 2f, 3f, 4f, 5f },
				1, 5, 3f);
	}
	
	@Test
	void testCircularOdd1() {
		doTest(5,
				new int[] { 1, 2, 3, 4, 5, 6 },
				new float[] { 1f, 2f, 3f, 4f, 5f, 6f },
				2, 6, 4f);
	}
	
	@Test
	void testReversedCircularOdd1() {
		doTest(5,
				new int[] { 1, 2, 3, 4, 5, 6 },
				new float[] { 6f, 5f, 4f, 3f, 2f, 1f },
				2, 6, 3f);
	}
	
	@Test
	void testReversedCircularOddSkip() {
		// 16,  19,  22,  26
		// 16,  22,  14,  16
		// --> 18 - 27 ==
		// 18  19  20  21  22  23  24  25  26  27
		// 16  22  22  22  14  14  14  14  16
		// --> SORTED =
		// 14  14  14  14  16  16  22  22  22
		//               ! 16 !
		
		doTest(5,
				new int[] { 1, 3, 7, 9, 14, 16, 19, 22, 26, 28 },
				new float[] { 17f, 15f, 13f, 100f, 11f, 16f, 22f, 14f, 16f, 3f },
				18, 27, 16f);
	}
	
	@Test
	void testInitialSkip() {
		doTest(2,
				new int[] { 0, 2 },
				new float[] { 1f, 2f },
				0, 1, 1f);
	}
		
	void doTest(int size, int[] timestamps, float[] data, int ts_start, int ts_end, float expectedMedian) {
		CircularBuffer b = new CircularBuffer(size);
		for (int i = 0; i < timestamps.length; i++) {
			b.add(timestamps[i], data[i]);
		}
		assertEquals(expectedMedian, b.median(ts_start, ts_end));
	}

}
