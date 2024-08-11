package all_java.collection.list;

import java.util.*; // module for ArrayList

public class ArrayListList {
	public static void print(Integer n) {
		System.out.println("Integer is " + n);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// List = interface 
		List<Integer> l1 = new ArrayList<Integer>(); 
        l1.add(0, 1); // adds 1 at 0 index 
        l1.add(1, 2); // adds 2 at 1 index 
        System.out.println(l1);
		
		// AbstractList = interface -- ArrayList & LinkedList = classes -- use these
		AbstractList<String> list = new LinkedList<String>(); 
		  
        // Use add() method to add elements in the list 
        list.add("Geeks"); 
        list.add("for"); 
        list.add("Geeks"); 
        list.add("10"); 
        list.add("20"); 
  
        // Displaying the AbstractList 
        System.out.println("AbstractList:" + list);
		
		// ArrayList inherits AbstractList class and implements List interface.
		// ArrayList is initialized by a size,
		// -- however the size can increase if collection grows or shrunk if objects are removed from the collection
		// type of data != primtive(int / float ) -- it should be Wrapper class(Integer / String)
		// dynamic allocation -- due to variable size at runtime -- we can create empty list inialization

		// creation methods -- ArrayList<Type> name = new ArrayList<SameType>
		int n = 13;
		// 1. empty list
		ArrayList<Integer> arrli = new ArrayList<Integer>();

		for (int i = 0; i < n; i++)
			arrli.add(i + 1);

		System.out.println(arrli); // whole list print in once
		System.out.println(arrli.size());

		// 2. with some initial capacity
		arrli = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++)
			arrli.add(i + 1);

		arrli.remove(3); // remove index = 3 element
		System.out.println(arrli);

		// 3. using some collection c -- ArrayList iniatialized with collection's elements

		// methods
		// 1. forEach(iter -> action_on_iter)
		// -- auto incement
		// -- action will be take place for each element/ iterator
		arrli.forEach(i -> System.out.println(i)); // iterator = i
		arrli.forEach(i -> print(i)); // passing into a method

		// 2. removeIf(iter -> condition) -- remove all elements which satisfies this
		// condition
		arrli.removeIf(i -> (i == 3));
		System.out.println(arrli);

		// 3. contains(element) -- returns true if given element = present, else false
		System.out.println(arrli.contains(3));
		System.out.println(arrli.contains(2));

		// 4. remove(index) -- remove given indexed element
		arrli.remove(0);
		// remove(element) -- remove given element
		// -- for the Integer ArrayList -- use -- remove(new Integer(element))
		// -- for other types(String etc.) -- remove(element)
		arrli.remove(new Integer(5));
		System.out.println(arrli);

		// we can also remove elements using iterator
		Iterator<Integer> itr = arrli.iterator(); // creating iter to ArrayList -- pointing first element
		// we can specify type as in this Integer -- but we can also skip this
		while (itr.hasNext()) {
			int x = (Integer) itr.next();
			if (x <= 6)
				itr.remove();
		}
		System.out.println(arrli);

		// 5. get(index) -- returns element at given index
		System.out.println(arrli.get(4));

		// 6. subList(start, end) -- returns list in the given range -- from start to
		// end-1
		System.out.println(arrli.subList(4, 7));

		// 7. set(index, element) -- replace old element at index with new element
		arrli.set(3, 50);
		System.out.println(arrli);

		// 8. size() -- retuns size

		// 9. ensureCapacity(new_capacity) -- increases capacity
		// if given capacity < current capacity -- NO CHANGE
		arrli.ensureCapacity(3);

		// 10. isEmpty() -- true if empty

		// 11. clear() -- remove all elements

		// 12. add(element) -- add element at the last
		arrli.add(1000);
		System.out.println(arrli);
		// add(index, element) -- add element at given index -- not replace -- shift the
		// other elements to the right
		arrli.add(2, 200);
		System.out.println(arrli);

		// 13. trimToSize() -- decrease capacity to size
		arrli.trimToSize();

		// 14. indexOf(element) -- returns the index of first occurance, -1 if not found
		System.out.println(arrli.indexOf(200));

		// 15. lastIndexOf(element) -- index of last occurance
		arrli.add(4, 200);
		System.out.println(arrli.lastIndexOf(200));

		// 16. clone() -- returns deep copy(change in one != change in another) --
		// returns object -- so cast it
		@SuppressWarnings("unchecked")
		ArrayList<Integer> dup_list = (ArrayList<Integer>) arrli.clone();
		System.out.println(dup_list);
		dup_list.add(4000);
		System.out.println(arrli);
		System.out.println(dup_list);

		// 17. toArray(array) -- converts ArrayList to Array & returns that -- returns
		// object -- so cast it
		Integer[] arry = new Integer[arrli.size()];
		arry = arrli.toArray(arry);
		System.out.println(Arrays.toString(arry));
		arry[0] = 435;
		System.out.println(Arrays.toString(arry));

	}
}
