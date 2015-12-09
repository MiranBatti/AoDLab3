package se.hig.aod.lab32;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.hig.aod.lab3.BSTPriorityQueue;
import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;

public class BSTUnsortedTest {
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
				
		System.out.println("Enqueue: ");
		
		int amount = 10000;		
		long t1 = System.currentTimeMillis();
		
		List<Integer> a = biggerL.subList(0, amount);
		
		for (Integer integer : a) {
			try {
				pq.enqueue(integer);
			} catch (DuplicateItemException e) {
				e.printStackTrace();
			}
		}
		
		long exetimeEnqueue = System.currentTimeMillis() - t1;
		
		System.out.println(exetimeEnqueue);
		
		for (Integer integer : a) {
			try {
				pq.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < smallerL.size(); i++) {
			try {
				pq.enqueue(smallerL.get(i));
			} catch (DuplicateItemException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < smallerL.size(); i++) {
			try {
				pq.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		
		long exetime2 = System.currentTimeMillis() - t1;
		
		System.out.println(exetime2 + "ms");
	}
	
}
