package se.hig.aod.lab32;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import se.hig.aod.lab3.BSTPriorityQueue;
import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;

public class BSTUnsortedTest {
	public static void main(String[] args) {
		BSTPriorityQueue<Integer> pq = new BSTPriorityQueue<Integer>();
		ArrayList<Integer> biggerL = null;
		ArrayList<Integer> smallerL = null;
		Reader r = new Reader();
		
		try {
			biggerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_640000.txt", 640000);
			smallerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_6400.txt", 6400);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i < biggerL.size(); i++) {
			try {
				pq.enqueue(biggerL.get(i)); 
			} catch (DuplicateItemException e) {
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
				System.out.println(pq.dequeue());
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < biggerL.size(); i++) {
			try {
				System.out.println(pq.dequeue()); 
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		
		
		long exetime = System.currentTimeMillis() - t1;
		
		System.out.println(exetime + "ms");
	}
	
}
