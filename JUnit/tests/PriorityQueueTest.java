package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.hig.aod.lab3.MyHeapPriorityQueue;
import se.hig.aod.lab3.QueueEmptyException;

public class PriorityQueueTest {

	MyHeapPriorityQueue<Integer> pq;
	int[] fixture = {2, 3, 1, 4, 5, 6, 7, 9, 8, 10};
	ArrayList<Integer> listFixture;
	
	@Before
	public void setUp() throws Exception {
		pq = new MyHeapPriorityQueue<Integer>();
		listFixture = new ArrayList<Integer>();
		for (int i = 0; i < fixture.length; i++) {
			listFixture.add(fixture[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void emptyOnConstruction() {
		assertTrue(pq.isEmpty());
	}
	
	@Test
	public void sizeIs0WhenEmpty() {
		assertEquals(0, pq.size());
	}

	@Test
	public void sizeIsNAndNotEmpty() {
		for (int i = 0; i < fixture.length; i++) {
//			pq.enqueue(fixture[i]);
			pq.enqueue(listFixture.get(i));
		}
		assertFalse(pq.isEmpty());
		assertEquals(10, pq.size());
	}
	
	@Test
	public void queueIsEmptyAfterDequeAllElements() {
		for (int i = 0; i < fixture.length; i++) {
//			pq.enqueue(fixture[i]);
			pq.enqueue(listFixture.get(i));
		}
		for (int i = 0; i < fixture.length; i++) {
			pq.dequeue();
		}
		assertTrue(pq.isEmpty());
	}
	
	@Test
	public void testQueuePriorityOrder() {
		for (int i = 0; i < fixture.length; i++) {
//			pq.enqueue(fixture[i]);
			pq.enqueue(listFixture.get(i));
		}
		
		for (int i = 0; i < fixture.length; i++) {
			assertEquals(i+1, pq.dequeue().intValue());
		}
	}
	
	@Test (expected = QueueEmptyException.class)
	public void dequeueOnEmptyThrowsException() {
		pq.dequeue();
	}
	
	@Test (expected = QueueEmptyException.class)
	public void peekingOnEmptyThrowsException() {
		pq.getFront();
	}
	
	@Test
	public void queueIsEmptyAfterClear() {
		pq.clear();
		assertTrue(pq.isEmpty());
		
		for (int i = 0; i < fixture.length; i++) {
//			pq.enqueue(fixture[i]);
			pq.enqueue(listFixture.get(i));
		}
		
		pq.clear();
		assertTrue(pq.isEmpty());
	}
	
	@Test
	public void sortedListTest() {
		Collections.sort(listFixture);
		
		for (int i = 0; i < fixture.length; i++) {
			pq.enqueue(listFixture.get(i));
		}
		
		for (int i = 0; i < fixture.length; i++) {
			assertEquals(i+1, pq.dequeue().intValue());			
		}
	}
	
	@Test
	public void reversedSortedListTest() {
		Collections.sort(listFixture, Collections.reverseOrder());
		
		for (int i = 0; i < fixture.length; i++) {
			pq.enqueue(listFixture.get(i));
		}
		
		for (int i = 0; i < fixture.length; i++) {
			assertEquals(i+1, pq.dequeue().intValue());			
		}
	}
}
