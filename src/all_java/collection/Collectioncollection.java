package all_java.collection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

public class Collectioncollection {
	public static void main(String[] args) {

		// Collection -- most upper interface -- all the list/set/queue/hash inherits the Collection
		// this way they can use the methods of it

		// AbstractCollection -- implemenets the Collection interface
		// constructor -- protected AbstractCollection()

		// Create an empty collection 
		AbstractCollection<Object> abs = new ArrayList<Object>();

		// methods
		// 1. add(element) -- add element at the end
		abs.add("Welcome"); 
		abs.add("To"); 
		abs.add("Geeks"); 
		abs.add("4"); 
		abs.add("Geeks");

		// Displaying the Collection 
		System.out.println("AbstractCollection: " + abs);

		// 2. addAll(Collection c) -- add all the data of Collection c 
		AbstractCollection<Object> abs1 = new ArrayList<Object>(); 
		System.out.println("AbstractCollection: " + abs1);
		abs1.addAll(abs);
		System.out.println("AbstractCollection: " + abs1);

		// 3. clear() -- delete all the data
		abs1.clear();
		System.out.println("AbstractCollection: " + abs1);

		// 4. contains(element) -- true if given element is present 
		System.out.println(abs.contains("To"));
		System.out.println(abs.contains("snsgjs"));
		
		// 5. containsAll(Collection c) -- true if it contains all elements of given Collection
		abs1 = new ArrayList<Object>(); 
		abs1.addAll(abs);
		abs1.add("sfjnkdjf");
		System.out.println(abs.containsAll(abs1));
		
		// 6. isEmpty() -- true if empty
		
		// 7. remove(element) -- remove given element if present
		abs.remove("4");
		System.out.println(abs);
		
		// 8. size() -- no of elements 
		
		// 9. toArray() -- returns an array containing all elements of Collection
		Object[] a = abs.toArray();
		for (Object i : a) {
			System.out.println(i);
		}
		
		// 10. toString() -- convert into String
		System.out.println(abs.toString());
		
		// 11. Creating an iterator 
        Iterator<Object> value = abs.iterator(); 
        System.out.println("The iterator values are: "); 
        while (value.hasNext()) { 
            System.out.println(value.next()); 
        } 
	}
}
