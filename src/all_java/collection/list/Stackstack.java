package all_java.collection.list;

import java.util.Stack;

public class Stackstack {
	public static void main(String[] args) {
		
		// uses vector internally
		Stack<Integer> st = new Stack<Integer>();

		// methods
		// 1. push(element) -- push onto the stack
		// 2. pop(element) -- remove & returns the top element
		// 3. peek() -- returns top element
		// 4. empty() -- true if empty
		// 5. search(element) -- returns position of element from top if present in the
		// stack, else -1

		st.push(0); // position = 3
		st.push(1); // position = 2
		st.push(2); // position = 1

		System.out.println(st.search(2));
	}
}
