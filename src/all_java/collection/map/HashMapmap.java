package all_java.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapmap {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// maps = key-value pair elements 
		// keys can't be duplicate but values can
		// interfaces -- Map / SortedMap
		// classes -- HashMap / LinkedHashMap / TreeMap 
		
		// HashMap
		// only one null key allowed -- multiple value can be null
		// unordered
		
		// performance depends on intial capacity and load factor
		
		// Constructors in HashMap
		
		// 1. HashMap(): It is the default constructor with initial capacity 16 and load factor 0.75.
		// 2. HashMap(int initial capacity): It creates a HashMap instance with specified initial capacity and load factor 0.75.
		// 3. HashMap(int initial capacity, float loadFactor)
		// 4. HashMap(Map map): It creates instance of HashMap with same mappings as specified map
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// methods
		// 1. puts(key,value) -- add key-value pair
		map.put("vishal", 10); 
	    map.put("sachin", 30); 
	    map.put("vaibhav", 20); 
		System.out.println(map);
		
		// 2. get(key) -- returns the value of given key if present
		System.out.println(map.get("sachin"));
		
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
		map.remove("vishal");
		System.out.println(map);
		
 		// 13. values() -- returns the collection of values
		System.out.println(map.values());
		
		// 14. putIfAbsent(key,value) -- key must be present -- if given key is not associated with any value(or mapped to NULL)
		// -- then that key will be mapped to given value and returns NULL -- else it will return currently mapped value
		map.put("ravi", null);
		System.out.println(map.putIfAbsent("ravi", 43));
		System.out.println(map);
		System.out.println(map.putIfAbsent("ravi", 43));
		
		// 15. replace(key,value) -- replace the value of given key by given value 
		map.put("abhi", 21);
		System.out.println(map);
		map.replace("abhi", 23);
		System.out.println(map);
		
		// 16. replace(K key, V oldValue, V newValue): replaces the value of given key if currently mapped to the given old value
		map.replace("abhi", 43, 222);
		System.out.println(map);
		map.replace("abhi", 23, 222);
		System.out.println(map);

		
		// traversing the HashMap
		// 1. iterator
		// Consider the hashmap contains student name and their marks 
        HashMap<String, Integer> hm =  new HashMap<String, Integer>(); 
  
        hm.put("GeeksforGeeks", 54); 
        hm.put("A computer portal", 80); 
        hm.put("For geeks", 82); 
  
        System.out.println("Created hashmap is" + hm); 
  
        Iterator hmIterator = hm.entrySet().iterator(); 
  
        // Iterate through the hashmap and add some bonus marks for every student 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            int marks = ((int)mapElement.getValue() + 10); 
            System.out.println(mapElement.getKey() + " : " + marks); 
        }
		
        // 2. for-each loop
        for (Map.Entry mapElement : hm.entrySet()) { 
            String key = (String)mapElement.getKey(); 
  
            // Add some bonus marks 
            // to all the students and print it 
            int value = ((int)mapElement.getValue() + 10); 
  
            System.out.println(key + " : " + value); 
        }
        
        // 3. Hashmap.forEach() 
        hm.forEach((k, v) -> System.out.println(k + " : " + (v + 10))); 
		
		

		// LinkedHashMap -- same as HashMap with one addition feature that it preserve the insertion 
        
        
        
        // HashTable -- HashMap internally uses this -- all methods are same
		
	}
}
