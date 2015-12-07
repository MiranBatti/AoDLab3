package se.hig.aod.lab32;

public class MyHeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T>{

	private T[] queue;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyHeapPriorityQueue(T element, int capacity) {
		queue = (T[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enqueue(T element) { // Arraybaserad: O(lg n+n)
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() { // deleteMin, Arraybaserad: O(n)
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() { // getMin, minsta elements har störst prioritet.
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
