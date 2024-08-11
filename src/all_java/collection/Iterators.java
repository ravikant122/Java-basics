package all_java.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Iterators {
	public static void main(String[] args) {
		
		// iterators -- used to retrieve element one by one
		
		// types
		// 1. enumeration
		// 2. iterator
		// 3. listIterator
		
		// 1. Enumeration
		// -- not for collection 
		
		// methods 
		// 1. hasMoreElement() -- true if enumeration contains element
		// 2. nextElement() -- retrieve next element in the list -- throws noSuchElementException if no element is present
		
		Vector<Integer> v = new Vector<Integer>(); 
		for (int i = 0; i < 10; i++) 
            v.addElement(i); 
        
        // At beginning e(cursor) will point to 
        // index just before the first element in v 
        Enumeration<Integer> e = v.elements(); 
        
        // Checking the next element availability 
        while (e.hasMoreElements()) 
        { 
            // moving cursor to next element 
            int i = e.nextElement(); 
  
            System.out.print(i + " "); 
        }
        System.out.println();  

        // Limitations of Enumeration :
        	// 1. Enumeration is for legacy classes(Vector, Hashtable) only. Hence it is not a universal iterator.
        	// 2. Remove operations can’t be performed using Enumeration.
        	// 3. Only forward direction iterating is possible.
		
		
        // 2. iterator
        // -- universal iterator -- applicable on collections also
        // -- we can perform both read and remove operations
        
        // methods
        // 1. hasNext() -- check for elements present or not
        // 2. next() -- retrieve next element
        // 3. remove() -- remove the current iterating element -- can be called once per next() -- one time for one next

        // At beginning itr(cursor) will point to 
        // index just before the first element in v
        Iterator<Integer> itr = v.iterator(); 
        
        // checking the next element availabilty 
        while (itr.hasNext()) 
        { 
            //  moving cursor to next element 
            int i = (Integer)itr.next(); 
  
            // getting even elements one by one 
            System.out.print(i + " "); 
  
            // Removing odd elements 
            if (i % 2 != 0) 
               itr.remove();  
        } 
        System.out.println();  
        // after removing odd elements
        System.out.println(v); 
        
        // Limitations of Iterator :
        	// 1. Only forward direction iterating is possible.
        	// 2. Replacement and addition of new element is not supported by Iterator.

        // remove() method can throw two exceptions
        	// 1. UnsupportedOperationException : If the remove operation is not supported by this iterator
        	// 2. IllegalStateException : If the next method has not yet been called, 
        	// 	  -- or the remove method has already been called after the last call to the next method
		
        
        // 3. listIterator
        // -- only applicable on list collection like arraylist, linkedlist etc.
        // --  It provides bi-directional iteration
        
        // methods
        // 1. hasNext() -- check for next elements present or not
        // 2. next() -- return the iterator to next element
        // 3. nextIndex() -- returns the next element index or size if element = last element
        // 4. hasPrevious() -- check for previous element present or not
        // 5. previous() -- returns the previous element
        // 6. previousIndex() -- returns the previous element index or -1 if element = first element
        // 7. remove() -- remove the current iterating value
        // 8. set(value) -- replace the last element returned by next() or previous() by given value
        // 9. add(value) -- add the given value in the list just after the current iterating value
        
        
        
        ListIterator<Integer> ltr = v.listIterator(); 
        
        // checking the next element availabilty 
        while (ltr.hasNext()) 
        { 
            //  moving cursor to next element 
            int i = (Integer)ltr.next(); 
  
            // getting even elements one by one 
            System.out.print(i + " "); 
  
            // Changing even numbers to odd and 
            // adding modified number again in  
            // iterator 
            if (i%2==0) 
            { 
                i++;  // Change to odd 
                ltr.set(i);  // set method to change value 
                ltr.add(i);  // to add 
            } 
        } 
        System.out.println(); 
        System.out.println(v);
        
        // Limitations of ListIterator : 
        // 1. It is the most powerful iterator but it is only applicable for List implemented classes, not a universal iterator.

	}
}
