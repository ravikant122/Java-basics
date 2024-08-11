package all_java.collection.set;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Setset {
	public static void main(String[] args) {
		
		// set -- unordered collection of object with no duplicates -- interface
		// implemented by HashSet / linkedHashSet / TreeSet(sorted set)
		
		Set<String> hash_Set = new HashSet<String>(); 
        hash_Set.add("Geeks"); 
        hash_Set.add("For"); 
        hash_Set.add("Geeks"); 
        hash_Set.add("Example"); 
        hash_Set.add("Set"); 
        System.out.print("Set output without the duplicates"); 
        System.out.println(hash_Set); 
  
        // Set deonstration using TreeSet 
        Set<String> tree_Set = new TreeSet<String>(hash_Set); 
        System.out.print("Sorted Set after passing into TreeSet"); 
        System.out.println(tree_Set); 
        
        
        // union / intersection / difference
        Set<Integer> a = new HashSet<Integer>(); 
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0})); 
        Set<Integer> b = new HashSet<Integer>(); 
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5})); 
  
        // just add one set into another -- To find union 
        Set<Integer> union = new HashSet<Integer>(a); 
        union.addAll(b); 
        System.out.print("Union of the two Set"); 
        System.out.println(union); 
  
        // retainAll(set) -- delete uncommon elements -- To find intersection 
        Set<Integer> intersection = new HashSet<Integer>(a); 
        intersection.retainAll(b); 
        System.out.print("Intersection of the two Set"); 
        System.out.println(intersection); 
  
        // removeAll(set) -- remove common elements -- To find the symmetric difference 
        Set<Integer> difference = new HashSet<Integer>(a); 
        difference.removeAll(b); 
        System.out.print("Difference of the two Set"); 
        System.out.println(difference);
        
        
        // AbstractSet -- just an Abstraction
        AbstractSet<Integer> abs_set = new TreeSet<Integer>(); 
	
	    // Populating abs_set 
	    abs_set.add(1); 
	    abs_set.add(2); 
	    abs_set.add(3); 
	    abs_set.add(4); 
	    abs_set.add(5); 
	
	    // print abs_set 
	    System.out.println("AbstractSet: " + abs_set);
        
	}
}
