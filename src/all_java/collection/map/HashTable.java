package all_java.collection.map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashTable {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// similar to HashMap -- but synchronised
		
		// creating a hash table 
        Hashtable<Integer, String> h = new Hashtable<Integer, String>(); 
  
        Hashtable<Integer, String> h1 = new Hashtable<Integer, String>(); 
  
        // put(key,val) 
        h.put(3, "Geeks"); 
        h.put(2, "forGeeks"); 
        h.put(1, "isBest"); 
  
        // create a clone or shallow copy of hash table h 
        h1 = (Hashtable<Integer, String>)h.clone(); 
  
        // checking clone h1 
        System.out.println("values in clone: " + h1); 
  
        // clear hash table h 
        h1.clear(); 
  
        // checking hash table h 
        System.out.println("after clearing: " + h1); 
        
        // Checking for the Value 'Geeks' 
        System.out.println("Is the value 'Geeks' present? " +  
                            h.contains("Geeks")); 
        
        // check whether a key exists or not 
        if (h.containsKey(3)) 
            System.out.println("Key found in table");
        
        // check whether a value exists or not 
        if (h.containsValue("geeks")) 
            System.out.println("value found in table");

        // create enumeration 
        Enumeration<String> e = h.elements(); // elements return values set
        while (e.hasMoreElements()) { 
            System.out.println(e.nextElement()); 
        } 
        
        // creating set view for hash table 
        Set<?> s = h.entrySet(); // it can handle any type
        
        // printing set entries 
        System.out.println("set entries: " + s); 
        
        // h.equals(Hashtable h1) : return true if equal else false
        
        // get(key) : used to get the value associated with key.
        System.out.println(h.get(2));
        
        // checking whether hash table h is empty or not 
        if (h.isEmpty()) 
            System.out.println("yes hash table is empty");
        
        // keys() -- returns key set
        // values() :returns value set
         
        // remove(key) :Removes key and its value
        h.remove(1);
        System.out.println(h);
        
        // size of hash table 
        System.out.println("Size is: " + h.size());
        
        // toString()
        System.out.println("string equivalent" + " of map: " + h.toString()); 
        
	}

}
