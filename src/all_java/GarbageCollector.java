package all_java;

public class GarbageCollector {
	
	String obj_name; 
	GarbageCollector i;
    public GarbageCollector(String obj_name) { 
        this.obj_name = obj_name; 
    } 
      
    @SuppressWarnings("unused")
	static void show() { 
        //object t1 inside method becomes unreachable when show() removed 
    	GarbageCollector t1 = new GarbageCollector("t1");  
        display(); 
          
    } 
    @SuppressWarnings("unused")
	static void display() { 
        //object t2 inside method becomes unreachable when display() removed 
    	GarbageCollector t2 = new GarbageCollector("t2");  
    } 
    
    @Override
    /* Overriding finalize method to check which object 
    is garbage collected */
    protected void finalize() throws Throwable { 
        // will print name of object 
        System.out.println(this.obj_name + " successfully garbage collected"); 
    } 
	
	public static void main(String[] args) {
		
		// Garbage Collector(GC) -- clear the memory which has no reference to it
		// free the memory by destroying the unreachable memory
		// help in get rid of OutOfMemoryErrors 
			
		// Unreachable memory : An memory is said to be unreachable iff it doesn't contain any reference to it
		int[] a = {1,2,3,4,5};
		System.out.println(a[0]);

		a=null;
		// now a points to nothing -- but the memory alloted for {1,2,3,4,5} is still not free 
		// -- so that memory got no reference -- so that memory is unreachable
		// GC will take care of that -- free this memory
		
		// it will free the memory no the object a
		
		// An memory is said to be eligible for GC(garbage collection) iff it is unreachable

		
		// methods to request JVM to run GC
		// 1. System.gc()
		// 2. Runtime.getRuntime().gc(); 
		// these are just suggestions to JVM to run GC -- no gurantees of that
		
		// finalize() -- GC calls this method once just before the destroying the object -- to perform clean up activities
		// -- implementation in Object class 
		// -- override it bcoz it has empty implementation to dispose of system resources or to perform other cleanup
		// it is the method of this class not some String/Integer/any other datatype
	    // so this woundn't be called if we make object of String/Integer/ any other datatype eligible to GC & call GC
		// if any exception occurs in finalize() -- then it ignores them --  let the program terminate normally
		
		// methods to make an object eligible for GC
		// 1. Object created inside a method : When a method is called it goes inside the stack frame. 
		// When the method is popped from the stack, all its members dies and if some objects were created inside it 
		// then these objects becomes unreachable or anonymous after method execution and thus becomes eligible for garbage collection
		show(); 
        
        // calling garbage collector 
        System.gc(); 
		
		// 2. re-assign the reference variable to some other object -- older object will be eligible for GC
        
        // 3. Nullify the reference variable 
        	
        // 4. Anonymous object : The reference id of an anonymous object was not stored anywhere. Hence, it becomes unreachable
        new GarbageCollector("t3");  
        
        System.gc();
        
        // 5. island of isolation 
        // -- Obj1 references Obj2 and Obj2 references Obj1 & Neither Obj1 nor Obj2 is referenced by any other object
		
        GarbageCollector t1 = new GarbageCollector("t4"); 
        GarbageCollector t2 = new GarbageCollector("t5"); 
        
        // Object of t1 gets a copy of t2 
        t1.i = t2; 
        
        // Object of t2 gets a copy of t1 
        t2.i = t1; 
             
        t1 = null; 
        // Till now no object eligible 
        // for garbage collection
        
        t2 = null; 
        //now two objects are eligible for 
        // garbage collection  
        
        // calling garbage collector 
        System.gc(); 
        
        // explanation -- t1.i = t2 & t2.i = t1 -- when t1 = null then we can still reach t1 by t2.i so no unreachable
        // but when t2 = null -- we can't reach both i -- unreachable -- that makes them eligible for GC
        
		
		// refer to GC of geeksforgeeks for real-life example of GC -- when to use
		
	}
}
