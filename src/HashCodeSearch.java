import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HashCodeSearch {

	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, Set<String>> map = new HashMap<>();	// Map to store all the words and their hash codes
		int counter = 0;
		
		// Reads the file
		Scanner in = new Scanner(new File("war_and_peace.txt"));
		in.useDelimiter("[^A-Za-z0-9_]+");
		while(in.hasNext()) {
			counter++;
			Set<String> temp;
			String word = in.next();
			// if the word is already in the map
			if(map.containsKey(word.hashCode())) {
				// reuse the existing set of words
				temp = map.get(word.hashCode());
			// if the word is not yet in the map
			} else {
				// create a new set of words
				temp = new TreeSet<>();
			}
			// put the hashCode and the word into the map
			temp.add(word);
			map.put(word.hashCode(), temp);		
		}
		in.close();
		
		// Find the duplicates
		int duplicateCounter = 0;
		for(Integer code : map.keySet()) {
			Set<String> tempSet = map.get(code);
			if(tempSet.size() > 1) {
				System.out.println(tempSet);
				duplicateCounter++;
			}
		}
		
		// Get the ratio of duplicates
		double ratio = duplicateCounter/(map.keySet().size() + duplicateCounter);		// the total number of words is the number of keys + the number of duplicates (ie words with the same key)
		// dupliucateCounter = 8
		// map.keySet().size() + duplicateCounter = 19422
		// This lines prints 0.000000e+00 instead of 1.3630617092112303E-5
		System.out.println(counter);
		System.out.printf("%e", ratio);
	}

}
