package all_java.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetset {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		// TreeSet -- sorted representation of elements of set
		// sorted in ascending order
		// doesn't preserve the insertion order -- but elements are sorted 
		// less retieval time due to faster access 
		// good for storing large amount of sorted data
		// internally uses self-balancing tree like red-black
		// operations like add, remove and search take O(Log n) time
		// operations like printing n elements in sorted order takes O(n) time
		// elements should be homogeneous and comparable -- comparable means element's class should implements a comparable fn
		// insertion of null into a TreeSet throws NullPointerException because while insertion of null, 
		// -- it gets compared to the existing elements and null cannot be compared to any value
		
		
		// Constructors of TreeSet class:

		// 1.  TreeSet t = new TreeSet();
			// This will create empty TreeSet object in which elements will get stored in default natural sorting order.
		// 2. TreeSet t = new TreeSet(Comparator comp);
			// This constructor is used when external specification of sorting order of elements is needed.
		// 3. TreeSet t = new TreeSet(Collection col);
			// This constructor is used when any conversion is needed from any Collection object to TreeSet object.
		// 4. TreeSet t = new TreeSet(SortedSet s);
			// This constructor is used to convert SortedSet object to TreeSet Object.
		
		TreeSet<StringBuffer> ts1 = new TreeSet<StringBuffer>(); 
        ts1.add(new StringBuffer("A")); 
        ts1.add(new StringBuffer("Z"));  
        ts1.add(new StringBuffer("L")); 
        ts1.add(new StringBuffer("B")); 
        ts1.add(new StringBuffer("O")); 
        System.out.println(ts1);
		
        // using custom comparator
		TreeSet<String> ts = new TreeSet<String>(Comparator.reverseOrder()); 
        ts.add("A"); 
        ts.add("Z");  
        ts.add("L"); 
        ts.add("B"); 
        ts.add("O"); 
		System.out.println(ts);
		// remove the type - String - and then add heterogeneous elements -- ERROR
        
        // methods
		// 1. add(value)
		// 2. addAll(Collection c)
		// 3. clear()
		// 4. contains(value)
		// 5. first() -- returns the first element if TreeSet is not empty else throws NoSuchElementException 
		// 6. last() -- returns the first element if TreeSet is not empty else throws NoSuchElementException 
		// 7. headSet(value) -- returns all the elements which are less than given value
		TreeSet<Integer> tree_set = new TreeSet<Integer>();   
        for(int i=1; i<20; i++)
        	tree_set.add(i); 
        
		TreeSet<Integer> head_set = new TreeSet<Integer>(); 
		
        head_set = (TreeSet<Integer>)tree_set.headSet(10); 
        
        Iterator iterate = head_set.iterator(); 
        System.out.println("The resultant values till head set: "); 
        while (iterate.hasNext()) { 
            System.out.println(iterate.next() + " "); 
        }
        
        // 8. tailSet(value) -- returns all elements which are equal or greater than given value
        // 9. isEmpty()
        // 10. size()
        // 11. clone()
        // 12. remove(value)
        // 13. subSet(startElement, endElement) -- returns elements from startElement(inclusive) to endElement(exclusive)
        // 14. ceiling(value) -- returns the least element greater than or equal to given value in the set if present else Exception
        // 15. floor(value) -- returns the greatest element less than or equal to given value in the set if present else Exception
        // 16. pollFirst() -- returns the first(lowest) element & remove it
        // 17. pollLast() -- returns the last(highest) element & remove it
        // 18. Iterator() -- returns iterator over the elements 
        // 19. descendingIterator() -- returns iterator over the elements in descending order
        // 20. descendingSet() -- returns the elements in reverse order
        System.out.println(tree_set.descendingSet());

	}
}
