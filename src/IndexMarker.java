import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndexMarker {

	public static void main(String[] args) throws FileNotFoundException {
		// File to open
		String filename = "ProcessRectangle.java"; //SUB "PaintJobCalculator.java"
		
		// Create a set with all the reserved words
		Set<String> reserved = new TreeSet<>();
		Scanner in = new Scanner(new File("reserved.txt"));
		while(in.hasNext()) {
			reserved.add(in.nextLine());
		}
		in.close();
		
		// Reads all the lines of the file
		Map<String,Set<Integer>> identifiers = new TreeMap<>();
		int lineCounter = 1;		// Keep track of the line number
		in = new Scanner(new File(filename));
		// Continue while there is a line to read
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String[] words = line.split("[^A-Za-z_]+");
			// Try to add all the words of the line to the map
			for(String element : words) {
				// Only add those that are not reserved words
				if (!reserved.contains(element) && !element.equals("")) {
					Set<Integer> tempSet;
					if(identifiers.get(element) != null) {
						tempSet = identifiers.get(element);
					} else {
						tempSet = new TreeSet<>();
					}
					tempSet.add(lineCounter);
					identifiers.put(element, tempSet);
				}
			}
			lineCounter++;
		}
		
		for(String key : identifiers.keySet()) {
			System.out.print(key + ": ");
			System.out.println(identifiers.get(key));
		}
		

	}

}
