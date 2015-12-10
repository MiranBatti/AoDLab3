package se.hig.aod.lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Kod från laborationsinstruktionen.
 * 
 * @author Peter Jenke
 * @author Miran Batti
 * @author Fredrik Lindorf
 *
 * @version 2015-12-07
 */
public class DataLoader {

	public DataLoader() {
		
	}
	
	public ArrayList<Integer> loadList(String path, int size) throws FileNotFoundException, IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		BufferedReader in = new BufferedReader(new FileReader(path));
		String l;
		while ((l = in.readLine()) != null && cnt < size) {
			list.add(Integer.parseInt(l));
			cnt++;
		}
		in.close();
		return list;
	}

} // end class
