package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> heightMap = new HashMap<>();
		
		heightMap.put("amelia", 64);
		heightMap.put("sophia", 63);
		heightMap.put("jovanka", 64);
		heightMap.put("john", 74);
		
		String name = "";
		boolean found = false;
		
		while (!found) {
			while (!name.equals("quit")) {
				System.out.println("name?");
				name = in.next();
				for(String test: heightMap.keySet()) {
					if (test.equals(name)) {
						found = true;
						System.out.println(heightMap.get(name));
						break;
					}
		
				}
			}
		}
		
		
		
	}
}
