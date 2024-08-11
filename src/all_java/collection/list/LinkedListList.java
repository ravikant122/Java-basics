package all_java.collection.list;

import java.util.Arrays;
import java.util.LinkedList; // for LinkedList

public class LinkedListList {
	public static void main(String[] args) {
		// LinkedList = doubly LL
		// inherit abstract list & implements list & deque interfaces

		// creation
		LinkedList<String> ll = new LinkedList<String>();

		// methods
		// 1. add(element) -- addLast(element) -- offer(element) -- offerLast(element)
		// -- append at the end
		ll.add("ravi");
		ll.add("alexa");
		System.out.println(ll);
		// add(index, element) -- add element at index & shift the remaining elements
		ll.add(0, "kant");
		System.out.println(ll);
		// addFirst(element) -- offerFirst(element) -- add element at the end
		ll.addFirst("kalu");
		System.out.println(ll);

		// 2. clear()
		// 3. contains(element) -- true if present, else false
		// 4. get(index)
		// 5. getFirst() -- element() -- peek() -- peekFirst() -- same -- returns first
		// element
		// 6. getLast() -- peekLast() -- returns Last element
		// 7. indexOf(element)
		// 8. lastIndexOf(element)
		// 9. set(index, element)
		// 10. size()

		// 11. poll() -- pollFirst() -- remove() -- removeFirst() -- returns first
		// element & remove it
		System.out.println(ll.poll());

		// 12. pollLast() -- removeLast() -- returns last element & remove it

		// 13. removeFirstOccurrence(element) -- remove the first occurance
		ll.addFirst("ravi");
		System.out.println(ll);
		ll.removeFirstOccurrence("ravi");
		System.out.println(ll);

		// 14. removeLastOccurrence(element) -- remove the last occurrence

		// 15. toArray(array) -- returns object -- so cast it
		String[] arry = new String[ll.size()];
		arry = (String[]) ll.toArray(arry);
		System.out.println(Arrays.toString(arry));
		arry[0] = "ravi";
		System.out.println(Arrays.toString(arry));

	}
}
