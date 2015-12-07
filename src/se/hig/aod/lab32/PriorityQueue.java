package se.hig.aod.lab32;
import java.lang.Comparable;
public interface PriorityQueue<T extends Comparable<? super T>> {
	public void clear();
	
	public boolean isEmpty();
	
	public int size();
	
	public void enqueue(T element);
	
	public T dequeue(); 
	
	public T getFront();
	
	public boolean isFull();
}
