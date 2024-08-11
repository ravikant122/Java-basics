package all_java;

class ExceptionInFnCalls {
	// It throws the Exception(ArithmeticException).
	// Appropriate Exception handler is not found within this method.
	static int divideByZero(int a, int b) {
		// this statement will cause ArithmeticException(/ by zero)
		int i = 10;
		try {
			i = a / b;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
		return i;
	}

	// The runTime System searches the appropriate Exception handler
	// in this method also but couldn't have found. So looking forward
	// on the call stack.
	static int computeDivision(int a, int b) {
		int res = 0;
		try {
			res = divideByZero(a, b);
		}
		// doesn't matches with ArithmeticException
		catch (NumberFormatException ex) // if u change this to ArithmeticException -- then it will be match with this &
											// won't search anymore
		{
			System.out.println("NumberFormatException is occured");
		}
		return res;
	}
}

// user-defined-Exception
class MyException extends Exception {

	private static final long serialVersionUID = 1L; // auto-generated

	MyException(String str) {
		super(str);
	}
}


// main class
public class ExceptionalHandling {
	@SuppressWarnings({ "null", "unused" })
	public static void main(String[] args) {
		// Exception = unwanted / unexpected event occures during run time -- distrubs the flow of program

		// ERROR = we can't catch these
		// Exception = we can catch these
		// if we catch the generated exception then no program termination immediately
		// -- code after that will also be executed

		// try-catch
		// -- we place the part of code which we think can generate Exceptions in try
		// -- catch is for catch exceptions -- if we code inside try generated exception then catch will handle than exception
		// -- if the Exception & Exception handler(catch's argument) matches -- then catch's block will be executed
		// -- the code inside catch 
		// -- without try-catch -- JVM will generate Exception & program will be terminated immediately

		String str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException ex) {
			System.out.println("you suck"); // we can any no of line of code in catch block
			int a = 10 + 30;
			System.out.println("value of a is " + a);
			System.out.println("u r trying to excess 0 len string");
		}
		System.out.println("out of the block");
		int a = 10, b = 20;
		System.out.println(a + b);

		// it's not mandotory that we've to mention Exception in catch Argument
		// -- we can just use Exception
		// -- because all the Exceptions are the subclass of the class Exception
		try {
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// there can multiple lines of code in try block
		// there can be multiple catch for one try -- for multiple type of exception

		// finally -- we can place a block of code under a keyword 'finally' -- that will execute anyway 
		// -- doesn't depend on whether exception generated or not
		// this is useful if suppose Exception generates & we want some action like all
		// file close, all program stop executing etc.

		try {
			System.out.println(str.length());
			int x = 5 / 0; // this won't generate -- bcoz upper line would already generated NullPointerException
		} catch (NullPointerException ex) {
			System.out.println("u r trying to excess 0 len string");
		} catch (ArithmeticException exe) {
			System.out.println(exe.getMessage());
		} finally {
			System.out.println("finally, u reached here");
		}
		System.out.println("out of the block");

// control flow b/w try-catch-finally
		// 1. Exception in try & handled by catch
		// catch -- yes
		// finally -- yes
		// outside -- yes
		// termination -- no

		// 2. Exception in try & not handled by catch
		// catch -- no
		// finally -- yes
		// outside -- no
		// termination -- yes

		// 3. no Exception in try
		// -- catch's code -- no
		// -- finally -- yes
		// -- outside code -- yes
		// termination -- no

// only try-finally
		// 4. Exception in try
		// -- finally -- yes
		// -- outside code -- no
		// termination -- yes

		// 5. no Exception in try
		// -- finally -- yes
		// -- outside code -- yes
		// termination -- no

		// finally will be executed -- anyways		
		
		// finding the exception in fn calls
		// suppose exception occurs during fn calls
		// -- then JVM will search the methods in reverse order of they called using call stack
		// -- if JVM finds a correct/suitable exception handler -- that can be in any method
		// -- not neccessary to be in first calling method
		// then it will stop seaching for the methods
		try {
			int i = ExceptionInFnCalls.computeDivision(1, 0);
		}

		// matching ArithmeticException
		catch (ArithmeticException ex) { // dividing be zero = Arithmetic Exception -- so it will leave all other
										// exception handlers
			// getMessage will print description of exception(here / by zero)
			System.out.println(ex.getMessage());
		}

		// methods to print Exception messages
		// 1. printStackTrace() -- nameOfException --> description --> whereTheCodeHasOccured
		try {
            int x = 20/0; 		// remove the comment then see
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2. toString() -- name --> description
		try {
            int x = 20/0; 
		} catch (Exception e) {
			// Prints what exception has been thrown
			System.out.println(e.toString());
		}

		// 3. getMessage() -- Exception in simple lang
		try {
//            int x = 20/0; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// creating user-defined-Exceptions -- our-own
		// 1. create a class that extends Exception
		// 2. create a constructor that takes the string -- string = message of
		// Exception -- that will we display when Exception will occur
		// 3. super(string) -- passing string to class Exception
		// 4. create obj of this class with string (message that u want to display)
		// 5. throw obj; -- to throw that Exception
		// 6. and accept obj in his class(MyException not Exception) in catch

		// Exception type = class name
		// description = string
		int d = 5;
		try {
			if (d < 10) {
				MyException obj = new MyException("d is less than 10");
				throw obj;
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		// this is gonna print bcoz we caught the Exception
		System.out.println("hello");


		// checked Exceptions
		// the exceptions that are checked at compile time
		// java has some predefined situation -- if any situation becomes true then it will generate error at compile time
		// ex: FileNotFoundException
		// uncomment below two lines

//		FileReader file = new FileReader("C:\\test\\a.txt"); 
//      BufferedReader fileInput = new BufferedReader(file);

		// we either have to put that code in try-catch or add throws in that function
			
		// Unchecked Exceptions
		// resolved at run time
		// ex: - ArithmeticException -- divide by zero
		// compile successfully -- if we divide 5 by 0
		// but throws Exception at run time

		// Interesting fact
		// if we divide double/float by zero -- o/p = infinity -- bcoz floating point algorithms
		// if we divide int by zero -- o/p = ArithmeticException
		
		// throw v/s throws
		// throw = to mannually throw exception -- used for both checked and unchecked
		// throws = keyword which is used in the signature of method to indicate 
		// -- that this method might throw one of the listed type exceptions
		// -- it only used for checked exception
		
		
		// exception in overriding methods 
		// https://www.benchresources.net/rules-for-exception-handling-w-r-t-method-overriding-in-java/
		// or go to CS bookmarks 
		
		
		// for exception hierarachy -- open img below the WrapperClass

	}
}
