package all_java;

@FunctionalInterface 
// to denote this interface as functional -- now if we add one more method then ERROR will be in this not in the lambda
// its optional
interface inter1 {
	void foo();
	
	// A non-abstract (or default) function can be there but no of abstract method should be one
    default void normalFun() { 
       System.out.println("Hello"); 
    }
}

interface inter2 {
	int operation(int x,int y);
}

interface inter3 {
	int divide(int x,int y);
}

interface inter4 {
	int getLength(String s);
}

public class Lambda implements inter1 {
	
	@Override
	public void foo() {
		System.out.println("hello i am one- implemented");
	}
	
	public static void main(String[] args) {
		
		// lambda -- why to use
		// 1. enable functional programming with object oriented
		// 2. readable and concise code
		// 3. easier-to-use APIs and Libraries
		// 4. enable support for parallel processing
		// 5. no need to make class to implement the interface with one abstract method
		
		// syntax -- variable = (arg1, arg2, ...) -> { body } ;
		// with body = 1 line -- then no need of curly braces
		
		// what is the type of variable(LHS of lambda expression)
		// it must be a functional interface
		// functional interface = interface with only one abstract method
		
		// simple lambda
		inter1 one = () -> System.out.println("hello i am one"); // RHS = body of the interface
		// we can think "one" = object of type "inter1" that is a interface
		// we need to call the method just like object calls the method of its class
		// at above - we just provided the body to the method of interface
		// to use the implementation we gotta call the method
		one.foo();
		
		// no need of return -- compiler will auto detect by looking at the statements
		inter2 two = (int x,int y) -> x+y; 
		System.out.println(two.operation(2, 5));
		
		inter2 three = (int x,int y) -> x*y;
		System.out.println(three.operation(2, 5));
		
		// multiline body
		inter3 four = (int x,int y) -> { 
			if(y==0) {
				return -1;
			} else {
				return x/y;
			}
		};
		four.divide(100, 10);

		// if no of args = 1 -> no need of paranthesis
		// also no need of type of args in lambda -- compiler will get that by looking at the method of interface
		inter4 five = (s) -> s.length();
		System.out.println(five.getLength("hello"));
		
		// another methods to do the same
		// 1. make a class that implements the interface & then make an obj of it & then call the method of interface through that obj
		Lambda lam = new Lambda();
		lam.foo();
		
		// 2. make an anonymous object that contains the method in itself
		Lambda lam2 = new Lambda() {
			@Override
			public void foo() {
				System.out.println("hello i am one- inside inside");
			}
		};
		lam2.foo();
		
		// runnable using lambda 
		// runnable - threading interface with one abstract method
		// without lambda
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("printed using runnable");
			}
		});
		myThread.start();
		
		// with  lambda
		Thread myThread1 = new Thread( () -> System.out.println("printed using lambda runnable") );
		myThread1.start();
		
		// above -- runnable = anomnous class -- so replace it with lambda
		// always replace anomnous class with lambda
		
		
	}	
}
