package test;

import se.hig.aod.lab3.MyHeapPriorityQueue;

public class TestMyHeap {
	public static void main(String[] args) {
		MyHeapPriorityQueue<Integer> pq = new MyHeapPriorityQueue<Integer>();
		int[] fixture = {2, 3, 1, 4, 5, 6, 7, 8, 10, 9};
		
		for (int i = 0; i < fixture.length; i++) {
			pq.enqueue(fixture[i]);
		}
		
		for (int i = 0; i < fixture.length; i++) {
			System.out.println(pq.dequeue());
		}
	}
}
