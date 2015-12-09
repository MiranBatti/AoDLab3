package se.hig.aod.lab3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.hig.aod.lab3.BSTPriorityQueue;
import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;

/**
 * This class measures the speed of inserting and removing elements from a BST based priority queue.
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-08
 */
public class BSTQueuePerformance {
	public static void main(String[] args) {
		BSTPriorityQueue<Integer> pq = new BSTPriorityQueue<Integer>();
		ArrayList<Integer> biggerL = null;
		ArrayList<Integer> smallerL = null;
		DataLoader r = new DataLoader();
		
		try {
			biggerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_640000.txt", 640000);
			smallerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_6400.txt", 6400);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		Collections.sort(biggerL);
//		Collections.sort(biggerL, Collections.reverseOrder());
		
		System.out.println("Enqueue: ");
		
		int amount = 640000;		
		long beginEnqueue = System.currentTimeMillis();
		
		List<Integer> a = biggerL.subList(0, amount);
		
		// Enqueue
		
		for (Integer integer : a) {
			try {
				pq.enqueue(integer);
			} catch (DuplicateItemException e) {
				e.printStackTrace();
			}
		}
		
		for (Integer integer : smallerL) {
			try {
				pq.enqueue(integer);
			} catch (DuplicateItemException e) {
				e.printStackTrace();
			}
		}
		
		long exetimeEnqueue = System.currentTimeMillis() - beginEnqueue;
		
		System.out.println(exetimeEnqueue);
		System.out.println("Dequeue: ");
		
		// Dequeue
		long beginDequeue = System.currentTimeMillis();
		
		for (@SuppressWarnings("unused") Integer integer : a) {
			try {
				pq.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		
		for (@SuppressWarnings("unused") Integer integer : smallerL) {
			try {
				pq.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long exetimeDequeue = System.currentTimeMillis() - beginDequeue;
		
		System.out.println(exetimeDequeue);
	}
	
}
