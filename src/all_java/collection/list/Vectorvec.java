package all_java.collection.list;

import java.util.Vector;

public class Vectorvec {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		// vector in Java = list in python
		// can contain mixed type of data

		// creation
		// 1. with default capacity = 10
		Vector v = new Vector();

		// 2. with given capacity
		Vector v1 = new Vector(20); 

		// methods
		// 1. add(element) -- add element at the end -- returns true if successfully
		// added, else false
		v.add(1);
		v.add(2);
		v.add(3);
		System.out.println(v);

		// 2. clear()
		// 3. contains(element)
		// 4. ensureCapacity(new capacaity)
		// 5. get(index)
		// 6. indexOf(element)
		// 7. lastIndexOf(element)
		// 8. isEmpty()
		// 9. remove(element) -- remove that element
		// 10. equals(another_vector) -- true if all elements at corresponding index are
		// equal
		// 11. trimToSize()
		// 12. toString()
		// 13. size()

		// 14. setSize() -- increases size -- new elements from old size to new size-1 =
		// null
		v.setSize(10);
		System.out.println(v);

		// 15. setElementAt(element,index) -- set the new element at given index
		v.setElementAt("ravi", 1);
		System.out.println(v);

		// 16. lastElement() -- returns the last element

		// 17. removeElement(element) -- remove the first occurrence
		v.add("ravi");
		v.removeElement("ravi");
		System.out.println(v);

		// 18. copyInto(array) -- copies all element into given array
		v1.add(1);
		v1.add(5);
		v1.add(2);

		Integer[] arr = new Integer[v1.size()];
		v1.copyInto(arr);
		System.out.println(arr[0]);
		System.out.println(arr[2]);

		// 19. capacity() -- returns capacity

		// 20. insertElementAt(element,index) -- it will add an extra element -- not
		// delete others
		v.insertElementAt(3002, 2);
		System.out.println(v);

	}
}
