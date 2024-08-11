package all_java;

// enum -- like a class named enum
enum Color // Derived data type -- Color
{
	RED, GREEN, BLUE; // constants of enums -- in Java -- value of constant = constant itself / in
						// C/C++ -- constants are valued from 0 to N-1, if there are N constants
}

/*
 * internally above enum Color is converted to class Color { public static final
 * Color RED = new Color(); -- bcoz of final -- we can't create child enums --
 * so no inheritance public static final Color BLUE = new Color(); public static
 * final Color GREEN = new Color(); }
 */

// enum constructor & method
enum Week {
	SUN, MON, TUE;

	Week() // constructor for enum -- it will be called for all of its constants,for every
			// single object of it --also called for array of all constants --default --
			// private
	{ // public & protected constructor aren't allowed in enums, bcoz then we can
		// create more constants of it -- but we can create constants only one time
		// A private constructor only allows constants to be constructed from within the
		// class definition.

		System.out.println("Constructor called for " + this.toString());
	}

	void weekInfo() // enums can have only concrete methods (not abstract methods)
	{
		System.out.println(this.toString() + "DAY");
	}
}

// enums constants with thier own custom value
enum TrafficSignal {
	// This will call enum constructor with one
	// String argument
	RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");

	// declaring private variable for getting values
	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor
	private TrafficSignal(String action) // string action = strings of constants
	{
		System.out.println("Constructor called");
		this.action = action;
	}
}

// instance variables
class Marks {
	int engMarks;
	int mathsMarks;
	int phyMarks;
}

// static variables
class Emp {

	// static variable salary
	public static double salary;
	public static String name = "Harsh";
}

public class Basics {
	// this is main class -- it can also have constructor but always main method
	// will execute first -- constructor will be called when object will be created
	// in any method
	// constructor
	Basics() {
		System.out.println("hello there, I'm constructor");
	}

	// we don't need forward declaration of classes & methods -- we can use them
	// before their declaration/intialization -- but only classes & methods

	@SuppressWarnings("unused")
	public void dayIsLike(Color color) {
		Basics b2 = new Basics();
		switch (color) {
		case RED:
			System.out.println("Red");
			break;
		case BLUE:
			System.out.println("Blue.");
			break;
		default:
			System.out.println("Green");
			break;
		}
	}

	// main method
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		// basic printing
		System.out.println("hello world"); // println -- print & create new line -- print(another fn to print) -- only
											// print

		// enum
		Color c1 = Color.RED; // Color instead of int/float/char etc.
		System.out.println(c1); // RED -- not some numeric value

		// we can also define enum in main_class also

		// enum object -- enum_name obj;
		Color color = Color.GREEN;

		// enums can be passed in switch statements
		Basics b1 = new Basics();
		b1.dayIsLike(color);

		// enum methods
		// 1. values() -- return all the constants of that enum
		Color arr[] = Color.values();

		// enum with loop
		for (Color col : arr) {
			// 2. ordinal() -- to find index of color.
			System.out.println(col + " at index " + col.ordinal());
		}
		// valueof(str) -- matches given string with all constants & return matched
		// constant
		System.out.println(Color.valueOf("RED"));

		// calling enum constructor & method
		Week w = Week.SUN;
		System.out.println(w);
		w.weekInfo();

		// enum's constants can have their custom value
		TrafficSignal[] sig = TrafficSignal.values();
		for (TrafficSignal signal : sig) {
			System.out.println("name " + signal.name() + " value " + signal.getAction());
		}

		// variables
		// types:
		// 1. local -- within block / method / constructor -- scope = within in which
		// it's declared -- must be initialized
		int a = 5;	
		a += 5;
		System.out.println("value of a = " + a);

		// 2. instance variable -- object variable -- declared outside of anyside block
		// or method or constructor but inside the class
		// scope = in the class in which they declared & anywhere through object --
		// default value = 0
		Marks obj1 = new Marks();
		System.out.println("hello"+obj1.phyMarks); // default value = 0
		obj1.engMarks = 50;
		obj1.mathsMarks = 80;
		obj1.phyMarks = 90;
		System.out.println("hello"+obj1.phyMarks);

		// 3. static variables -- class variables -- default 0 -- scope = anywhere
		// all objects would share the same static variable
		// excessing -- normal in class -- for outside = use Class_name.Variable_name --
		// no need of creating an object
		Emp.salary = 1000;
		System.out.println(Emp.name + "'s average salary:" + Emp.salary);

		// 4. final -- keyword -- instead of const, use this -- we can initialize it only once
		// either with declaration or with after declaration but only once
		final int x = 5;
		final float y;
		y=11;
		final char c; // we have to initialize before accessing
		// if we have more than one constructor -- then we've to intialize the final
		// variable in all constructors bcoz diff obj can call diff constructors

		// enhanced loop( for-each loop ) -- simpler way of for loop
		String array[] = { "harry", "ram", "shyam" };
		for (String str : array)
			System.out.println(str);

		// drawbacks:
		// 1. can't modify the array -- only that variable will change
		int ar[] = { 1, 2, 3, 4, 5, 6 };
		int index = 0;
		for (int ii : ar) {
			ii = ii * 2;
			System.out.println(ar[index++]);
		}

		// 2. can't have the index -- variable = value not index
		// 3. only forward iteration possible

		// widening primitive conversion
		System.out.println("Y" + "O"); // double quotes = string
		System.out.println('L' + 'O'); // single quotes with operator = ASCII -- ASCII values will be added bcoz of +
										// -- it will do operation according to operator
		System.out.println('L'); // single quotes = also string
		System.out.println('O');

		// type casting -- type1 var1 = (type1)var2 -- var2 is of some other type
		// 1. it will auto cast the when the types are compatible -- all numeric
		// datatypes
		int t = 5;
		long tt = t;
		// byte --> short --> int --> long --> float --> double == automatically for short to larger

		// 2. for long to short -- we've to do cast explicitly x
		int d = (int) tt;

		// 3. for byte -- first it will remove the fractional part(of double/float) &
		// then it will take the 8 bits(most right)
		float ff = 300.3232f;
		byte bb = (byte) ff; // it will take only last 8 bits(rightmost) -- other discarded due to size of 1
								// byte = 8 bits
		System.out.println(bb);
		// byte = -128 to 127

		// 4. in diff types
		char ch = 'c';
		int t1 = 65;
		int t2 = 70;
		ch = (char) t1; // explicit
		System.out.println(ch);
		t2=ch; // implicit
		System.out.println(t2);

		// break with label -- to break outer loop -- means break from both loops
		outer: // a label
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 1)
					break outer; // it will break outer
				System.out.println("value of j = " + j);
			}
		}

		// continue with label -- the control will reach the label every time
		outer: 
		for (int i = 0; i < 10; i++) { // this will run for only 10 times -- not infinity
			for (int j = 0; j < 10; j++) {
				if (j == 1)
					continue outer; // the control will reach to outer label 
					// this is equal to break in this loop
				System.out.println(" value of j = " + j);
			}
		}
		
		// ERROR -- declaring a variable above & then for loop
		// in C++ -- this works
		// int a1=10;  // uncomment this then ERROR
		for(int a1=0; a1<10; a1++)
			System.out.println(a1);

		
		// Java doesn't support goto

	}
}
