package builtin.datastructures;

import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	
	public static void testTreeMap() {
		TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
		treeMap.put("Alice",1);
		treeMap.put("Bob",2);
		treeMap.put("Claire",3);
		for(String key:treeMap.descendingKeySet()) {
			System.out.println("("+key+", "+treeMap.get(key)+")");
		}
	}
	
	public static void main(String[] args) {
		testTreeMap();
	}
}
