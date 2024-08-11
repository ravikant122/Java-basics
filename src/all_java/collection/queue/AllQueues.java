package all_java.collection.queue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class the_comp implements Comparator<Integer> // min heap
{
	@Override
	public int compare(Integer x, Integer y) {
		if (x < y)
			return 1;
		if (x == y)
			return 0;
		return -1;
	}
}

public class AllQueues {
	public static void main(String[] args) {
		
		// Queue = interface -- LinkedList & Priority Queue = classes -- use these to 
		// use queue -- all basic of fn queue exists in both
		// if wanna use
		Queue<Integer> q = new LinkedList<>();
		for (int i=0; i<5; i++) 
		     q.add(i); 
		System.out.println("Elements of queue - "+q);
		
		// add() / peek() / element() / remove() / poll() / size()

		// Priority Queue -- min heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		// add(element) -- offer(element)
		pq.add(7);
		pq.add(2);
		pq.add(8);
		pq.add(1);
		pq.add(9);

		// peek() -- head -- first element
		System.out.println(pq.peek());

		// iterator -- to print whole
		Iterator<Integer> itr = pq.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		// poll() -- remove & return head
		// contains(element) -- true if given element is present
		// size()
		// remove(element)

		// max heap
		// 1. Comaparator
		pq = new PriorityQueue<Integer>(new the_comp());
		pq.add(7);
		pq.add(1);
		pq.add(8);
		pq.add(2);
		pq.add(9);
		System.out.println(pq.peek());

		itr = pq.iterator(); // whole list != in descend order -- but top = element = greatest -- it will
								// adjust as u remove element
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		// 2. Collections.reverseOrder()
		pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(7);
		pq.add(1);
		pq.add(8);
		pq.add(2);
		pq.add(9);
		System.out.println(pq.peek());

		itr = pq.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		// 2. (x, y) -> y - x
		pq = new PriorityQueue<Integer>((x, y) -> y - x);
		pq.add(7);
		pq.add(2);
		pq.add(8);
		pq.add(1);
		pq.add(9);
		System.out.println(pq.peek());

		itr = pq.iterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();

		
		// Deque - interface 
		// implementation classes -- ArrayDeque(faster) / LinkedList(slower)
		Deque<String> deque = new ArrayDeque<String>();
		
		// methods
		// 1. add(element)/addLast(element) -- add element at the end
		deque.add("Element 1 (Tail)"); 
		
		// 2. addFirst(element)/push(element) -- add element at the front
        deque.addFirst("Element 2 (Head)");  
        
        // 3. offer(element)/offerLast(element)
        // -- Adds an element at the end and returns a boolean to explain if the insertion was successful
        deque.offer("Element 5 (Tail)"); 
        
        // 4. offerFirst(element): Adds an element to the head and returns a boolean to explain if the insertion was successful
        deque.offerFirst("Element 6 (Head)"); 
  
        // 5. removeFirst(): Removes the element at the head.
        // 6. removeLast(): Removes the element at the tail.
        
        // 7. peek()/peekFirst() --  returns the head, without deleting it from the deque 
        System.out.println("Peek " + deque.peek()); 
        System.out.println("After peek: " + deque); 
        // peekLast() -- for last element without deleting it
        System.out.println("Peek " + deque.peekLast()); 
        
        // 8. Pop returns the head, and removes it from the deque 
        System.out.println("Pop " + deque.pop()); 
        System.out.println("After pop: " + deque); 
        
        // 9. poll()/pollFirst(): Retrieves and removes the first element of this deque, or returns null if this deque is empty
        System.out.println("pollfirst " + deque.pollFirst()); 
        System.out.println("After pollfirst: " + deque); 
        
        // 10. pollLast(): Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        System.out.println("pollLast " + deque.pollLast()); 
        System.out.println("After pollLast: " + deque); 
        
        // 11. contains(element) -- return true if present else false
        System.out.println("Contains element 3: " + deque.contains("Element 3 (Tail)")); 
        
        System.out.println(deque + "\n"); 
  
        // Iterate through the queue elements.
        Iterator<String> iterator = deque.iterator(); 
        while (iterator.hasNext()) 
            System.out.println("\t" + iterator.next()); 
  
        // Reverse order iterator 
        Iterator<String> reverse = deque.descendingIterator(); 
        while (reverse.hasNext()) 
            System.out.println("\t" + reverse.next()); 
        

		// use LinkedList -- for Queue & Deque
		// use PriorityQueue -- for min / max heap
		// ArrayDeque -- for Deque only

	}
}
