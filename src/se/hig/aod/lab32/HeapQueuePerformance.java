package se.hig.aod.lab32;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.hig.aod.lab3.DuplicateItemException;
import se.hig.aod.lab3.EmptyQueueException;
import se.hig.aod.lab3.HeapPriorityQueue;

public class HeapQueuePerformance {
	public static void main(String[] args) throws DuplicateItemException, EmptyQueueException {
		HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<Integer>(); // 1. skapa instans av kön
//		MyHeapPriorityQueue<Integer> pq = new MyHeapPriorityQueue<Integer>(6464000);
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
		
//		Collections.sort(biggerL); // aktivera kod för sorterat data.
		Collections.sort(biggerL, Collections.reverseOrder()); // aktivera kod för sorterat omvänt data.
		System.out.println("Enqueue: ");
		
		//Enqueue
		int amount = 640000;	// behöver handläggning, ändra värdet för större data.
		List<Integer> a = biggerL.subList(0, amount);
		
		long beginEnqueueTimer = System.currentTimeMillis();
			
		for (Integer integer : a) {
			pq.enqueue(integer); // 2. Lagra data från 640000.txt i kön.
		}
		
		for (Integer integer : smallerL) {
			pq.enqueue(integer); // 3. Lagra data från 6400.txt i kön.
		}
		
		long exetimeEnqueue = System.currentTimeMillis() - beginEnqueueTimer; // mät tiden för lagring av data
		System.out.println(exetimeEnqueue);
		
		System.out.println("Dequeue: ");
		
		// Dequeue
		long beginDequeueTimer = System.currentTimeMillis();
		
		for (@SuppressWarnings("unused") Integer integer : a) {
			pq.dequeue(); // 2. Ta bort data från 640000.txt
		}	
		
		for (@SuppressWarnings("unused") Integer integer : smallerL) {
			pq.dequeue(); // 3. Ta bort data från 6400.txt
		}
		
		long exetimeDequeue = System.currentTimeMillis() - beginDequeueTimer;
		
		System.out.println(exetimeDequeue);
	}
}// end class
