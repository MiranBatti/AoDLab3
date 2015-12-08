package se.hig.aod.lab32;

import java.lang.Comparable;

public class MyHeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T>{

	private T[] queue;
	private int nbrOfElements, capacity;
	
	@SuppressWarnings("unchecked")
	public MyHeapPriorityQueue(int capacity) {
		queue = (T[]) new Comparable[capacity + 1];
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
		if(nbrOfElements == queue.length - 1)
			resizeArray(); // förstorar våran queue array.*/
		int current = size() + 1;
		queue[current] = element;

		nbrOfElements++;
		int index = nbrOfElements; 

		for(int i  = index; i >= 2 && element.compareTo(queue[getParent(i)]) < 0; i /= 2) 
			swap(i, getParent(i));
		
//		bubbleUp(current);
		/*
		while(current > 0 && queue[current].compareTo(queue[getParent(current)]) < 0) {
			swap(current, getParent(current));
			current = getParent(current);
		}*/
		
	}

	@Override
	public T dequeue() { // deleteMin, Arraybaserad: O(n)
		if(isEmpty())  {
			System.out.println("Kön är tom."); // behöver felhantering.
			return null;
		}
		
		T rvalue = getFront(); 
		queue[1] = queue[nbrOfElements--];
//		recoverQueue(1); 
		trickleDown(1);
		return rvalue;
		
		/*
		T tmp = queue[nbrOfElements--];		
		trickleDown(1);
		queue[nbrOfElements + 1] = null;

		return tmp;*/
	}

	@Override
	public T getFront() { // getMin, minsta elements har störst prioritet.
		if(this.isEmpty()) {
			System.out.println("Queue is empty"); // behöver felhantering
			return null;
		}
		return queue[1];
	}

	@Override
	public boolean isFull() {
		return (nbrOfElements == capacity);
	}
	
	private int getParent(int index) {
		if(index <= 0) 
			return -1;
		return (index) / 2;
	}

	private void swap(int i, int j) {
		T element = queue[i];
		queue[i] = queue[j];
		queue[j] = element;
	}
	
	private void resizeArray() {
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[queue.length * 2];
		for (int i = 0; i < nbrOfElements; i++) {
			tmp[i] = queue[i];
		}
		
		queue = tmp;
	}

	private void bubbleUp(int position) {
		while(position > 1 && queue[position].compareTo(queue[getParent(position)]) < 0) {
			swap(position, position/2);
            position /= 2;			
		}
	}
	
	private void trickleDown(int parentIndex) {
		int left = 2 * parentIndex;
		int right = (2 * parentIndex) + 1;
		int min = parentIndex;

		if (nbrOfElements > left && queue[left].compareTo(queue[min]) < 0)
			min = left;
		if (nbrOfElements > right && queue[right].compareTo(queue[min]) < 0)
			min = right;

		if (min != parentIndex) {
			swap(parentIndex, min);
			trickleDown(min);
		}
	}	
	
	private int compare(T o1, T o2) { return o1.compareTo(o2); }
	
	
	private void recoverQueue(int index) { 
		T tmp = queue[index]; 
		int child; 
		
		while((child = index * 2) <= nbrOfElements) {
			if(child != nbrOfElements && queue[child + 1].compareTo(queue[child]) < 0)
				child++;
			if(compare(queue[child], tmp) >= 0) 
				break; 
			queue[index] = queue[child]; 
			index = child; 
			}
		queue[index] = tmp;	
	}

	
}

