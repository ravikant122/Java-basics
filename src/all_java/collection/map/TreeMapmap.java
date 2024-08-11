package all_java.collection.map;

import java.util.TreeMap;

public class TreeMapmap {
	public static void main(String[] args) {
		
		// TreeMap -- map with sorted order of keys
		// -- doesn't allows the null values
		
		// Constructors in TreeMap
			// 1. TreeMap(): It is the default constructor with natural order of sorting of its keys
			// 2. TreeMap(Comparator c): sorting acc. to given Comparator fn
			// 3. TreeMap(Map m): It creates instance of TreeMap with same mappings as specified map
			// 4. TreeMap(SortedMap sm): It creates instance of TreeMap with same mappings as specified map
		
		// TC = log(n)		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		// methods
		// 1. puts(key,value) -- add key-value pair
		map.put(30, "vishal"); 
	    map.put(10, "sachin"); 
	    map.put(20, "vaibhav"); 
		System.out.println(map);
		
		// 2. get(key) -- returns the value of given key if present
		System.out.println(map.get(10));
		
		// 3. clear()
		// 4. size()
		// 5. containsKey(key) -- true if given key is present
		// 6. containsValue(value) -- true if given value is present
		// 7. clone()
		// 8. isEmpty()

		// 9. keySet() -- returns the keys as a set
		System.out.println(map.keySet());
		
	    // 10. entrySet() -- returns the whole map as a set -- key=value
		System.out.println(map.entrySet());
		
		// 11. putAll(Map m) -- copy all the elements from given map
		// 12. remove(key) -- remove the key-value pair of given key
		map.remove(30);
		System.out.println(map);
		
 		// 13. values() -- returns the collection of values
		System.out.println(map.values());
		
		// 14. firstKey(): The method returns the first key currently in this tree map
		System.out.println(map.firstKey());
	    map.put(5, "vaib"); 
		System.out.println(map.firstKey());
		
		// 15. lastKey(): The method returns the last key currently in this tree map
		System.out.println(map.lastKey());
	    map.put(45, "vaib"); 
		System.out.println(map.lastKey());
		
		// 16. firstEntry() -- pair of lowest key
		System.out.println(map.firstEntry());
		
		// 17. lastEntry() -- pair of highest key
		System.out.println(map.lastEntry());
	}
}
