package se.hig.aod.lab32;

import java.lang.Comparable;

public class MyHeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T>{

	private T[] queue;
	private int nbrOfElements, capacity;
	
	@SuppressWarnings("unchecked")
	public MyHeapPriorityQueue(int capacity) {
		queue = (T[]) new Comparable[capacity];
		nbrOfElements = 0;
		this.capacity = capacity;
	}
	
	@Override
	public void clear() {
		nbrOfElements = 0;
		queue = null;
	}

	@Override
	public boolean isEmpty() {
		return (nbrOfElements == 0);
	}

	@Override
	public int size() {
		return nbrOfElements;
	}

	@Override
	public void enqueue(T element) { // Arraybaserad: O(lg n+n)
		/*
		if(nbrOfElements >= capacity) {
			System.out.println("Kön är full"); // behöver felhantering
			return;
		}*/
		
		if(nbrOfElements >= capacity)
			resizeArray(); // förstorar våran queue array.
		
		int current = nbrOfElements++;
		queue[current] = element;
		
		
		while(current > 0 && queue[current].compareTo(queue[getParent(current)]) < 0) {
			swap(queue, current, getParent(current));
		}
		
	}

	@Override
	public T dequeue() { // deleteMin, Arraybaserad: O(n)
		if(isEmpty())
			System.out.println("Kön är tom."); // behöver felhantering.
		T tmp = queue[0];
		int tmpSize = nbrOfElements;
		
		for (int i = 0; i < tmpSize; i++) {
			queue[i] = queue[i + 1];
		}
		
		nbrOfElements--;
		
		return tmp;
	}

	@Override
	public T getFront() { // getMin, minsta elements har störst prioritet.
		if(this.isEmpty()) 
			System.out.println("Queue is empty"); // behöver felhantering
		return queue[0];
	}

	@Override
	public boolean isFull() {
		return (nbrOfElements == capacity);
	}
	
	private int getParent(int index) {
		if(index <= 0) return -1; // kanske index 1?
		return (index - 1) / 2;
	}

	private static <T> void swap(T[] queue, int i, int j) {
		T element = queue[i];
		queue[i] = queue[j];
		queue[j] = element;
	}
	
	private boolean isLeaf(int position) {
		return (!hasLeftChild(position) && !hasRightChild(position));
	}

	private boolean hasLeftChild(int position)
	{
		int currentPosition = nbrOfElements++;
		return (currentPosition > 2*position + 1);
	}

	private boolean hasRightChild(int position)
	{
		int currentPosition = nbrOfElements++;
		return (currentPosition > 2*position + 2);
	}
	
	private void resizeArray() {
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++) {
			tmp[i] = queue[i];
		}
		
		queue = tmp;
	}
	
}

