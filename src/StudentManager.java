import java.util.Map;
import java.util.TreeMap;

/**
 * Manage a roster of students and their grade
 * @author isabelle delmas
 *
 */
public class StudentManager {
	Map<String, String> map;
	
	/**
	 * Default constructor
	 */
	public StudentManager(){
		this.map = new TreeMap<>();
	}

	/**
	 * Add a student to the class
	 * @param name name of the student
	 * @param grade letter grade
	 */
	public void add(String name, String grade) {
		this.map.put(name,  grade);
	}
	/**
	 * Remove the association of this name and gpa
	 * @param name name of the student to remove from the class
	 */
	public void remove(String name) {
		this.map.remove(name);
	}
	
	/**
	 *  Get the number of students in the class
	 * @return number of student in the class
	 */
	public int getClassSize() {
		return this.map.size();
	}
	
	/**
	 * Get a printable roster
	 * @return a printable roster
	 */
	public String getPrintableRoster() {
		String roster = "";
		// Go through the map (stored in alphabetical order since using a tree map)
		for(String name : map.keySet()) {
			roster += name + ": " + map.get(name) + "\n";
		}
		return roster;
	}
}
