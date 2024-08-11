package all_java.collection.set;

import java.util.HashSet;

public class HashSetset {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		// HashSet -- implements set interface
		// -- underlying data structure for this = hashTable -- which actually uses hashMap
		// -- constant time performance for operation like -- add / remove / contains / size
		// -- duplicate values not allowed
		// -- Null element are allowed -- as it can't contains more than one null value
		// -- unordered elements
		// -- elements can be heterogeneous
		
		
		// Constructors
		// 1. HashSet h = new HashSet();
			// Default initial capacity is 16 and default load factor is 0.75.
		// 2. HashSet h = new HashSet(int initialCapacity);
			// default loadFactor of 0.75
		// 3. HashSet h = new HashSet(int initialCapacity, float loadFactor);
		// 4. HashSet h = new HashSet(Collection C);
		
		
		// how to maintain high performance of HashSet operations
		// factors = initial capacity & load factor
		// initial capacity = no of buckets when hashTable is created
		// load factor = measure of how full the HashSet is allowed to get before its capacity is automatically increased
	
		// load factor = no of stored elements in the table / size(capacity) of the table
		
		// how the size of hashTable increases automatically
		// -- When the number of entries in the hash table exceeds the product of the load factor and the current capacity
		// -- the hash table is rehashed (that is, internal data structures are rebuilt) 
		// -- so that the hash table has approximately twice the number of buckets
		
		
		HashSet<String> h = new HashSet<String>(); 
        h.add("India"); 
        h.add("Australia"); 
        h.add("South Africa"); 
        h.add("India");
        System.out.println(h);
        // remove the type - String - and then add heterogeneous elements
		
        
        // internal working of HashSet
        // -- All the classes of Set interface internally backed up by Map. HashSet uses HashMap for storing its object internally
        // -- key = element of set -- value = constant value = same for all keys(elements)
        
		// methods
        // 1. add(element) -- add the given element if not present -- if present then returns false
        h.add("South Africa"); 
        
        // 2. contains(element) -- true if element is present else false
        System.out.println(h.contains("India"));
        
        // 3. remove(element) -- remove the element if present
        h.remove("South Africa");
        System.out.println(h);
        
        // 4. isEmpty() -- true if empty
        
        // 5. size() -- returns size = no of elements
        System.out.println(h.size());
        
        // 6. clone() -- creates a shallow copy of set -- returns Object typed -- so type cast it
        HashSet cloned_set = new HashSet(); 
        cloned_set = (HashSet)h.clone(); 
        System.out.println("The new set: " + cloned_set); 
		 
        // 7. clear()
        
        
        // LinkedHashSet -- same as HashSet except it preserve the insertion order
        // internally uses doubly linked list
		
	}
}
