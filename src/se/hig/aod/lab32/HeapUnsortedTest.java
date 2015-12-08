package se.hig.aod.lab32;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;

public class HeapUnsortedTest {
	public static void main(String[] args) throws DuplicateItemException, EmptyQueueException {
//		HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<Integer>(640000);
		MyHeapPriorityQueue<Integer> pq = new MyHeapPriorityQueue<Integer>(6464000);
		ArrayList<Integer> biggerL = null;
		ArrayList<Integer> smallerL = null;
		DataLoader r = new DataLoader();
		
		try {
			biggerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_640000.txt", 640000);
			smallerL = r.loadList("C:/Users/Miran/git/AoDLab3/src/resources/data_6400.txt", 6400);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i < biggerL.size(); i++) {
			pq.enqueue(biggerL.get(i)); 
		}
		
		for (int i = 0; i < smallerL.size(); i++) {
			pq.enqueue(smallerL.get(i));
		}
		
		for (int i = 0; i < smallerL.size(); i++) {
			System.out.println(pq.dequeue());
		}
		
		for (int i = 0; i < biggerL.size(); i++) {
			System.out.println(pq.dequeue()); 
		}
		
		long exetime = System.currentTimeMillis() - t1;
		
		System.out.println(exetime + "ms");
	}
}// end class
