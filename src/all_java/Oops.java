package all_java;

// swap objects
class Car {
	int model, no;

	Car(int model, int no) {
		this.model = model;
		this.no = no;
	}

	void print() {
		System.out.println("model = " + model + " no = " + no);
	}
}

// inheritance
class Bicycle {
	// the Bicycle class has two fields
	public int gear;
	public int speed;
	int value = 100;

	public Bicycle() {
		System.out.println("unparameterized constuctor");
	}
	// the Bicycle class has one constructor
	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
		System.out.println("superclass called");
		System.out.println("hashcode of obj " + this.hashCode());
		System.out.println("Sub class " + this.getClass().getSimpleName()); // prints subclass's name
		System.out.println("super class " + this.getClass().getSuperclass().getSimpleName()); // prints superclass name
	}

	// the Bicycle class has three methods
	public void applyBrake(int decrement) {
		speed -= decrement;
	}

	public void speedUp(int increment) {
		speed += increment;
	}

	// toString() method of Object Class
	public String toString() {
		return ("No of gears are " + gear + "    " + "speed of bicycle is " + speed);
	}

	public void printing() {
		System.out.println("SuperClass called");
	}
}

// derived class 
class MountainBike extends Bicycle {
	// the MountainBike subclass adds one more field
	public int seatHeight;
	int value = 10;

	// the MountainBike subclass has one constructor
	public MountainBike(int gear, int speed, int startHeight) {
		// invoking parent-class(Bicycle) constructor
		super(gear, speed);
        seatHeight = startHeight; 
		System.out.println("subclass called");
		seatHeight = startHeight;
		System.out.println("hashcode of obj " + this.hashCode());
		System.out.println("sub class " + this.getClass().getSimpleName()); // prints subclass(this class) name
		System.out.println("super class " + this.getClass().getSuperclass().getSimpleName()); // prints superclass's name
	}

	// the MountainBike subclass adds one more method
	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	// overriding toString() method of Bicycle to print more info
	@Override // for overridden methods in subclass -- we need to put this
	public String toString() {
		return ("seat height is " + seatHeight);
	}
}

// interface
interface Vehicle {

	// all are the abstract methods.
	void changeGear(int a);

	void speedUp(int a);

	void applyBrakes(int a);

	// default method in interface
	default void display() {
		System.out.println("This is default methods of interface, defined in interface");
	}

	// static method in interface
	static void disp() {
		System.out.println("This is static method of interface, defined in interface");
	}
}

// class that implements the interface
class Bicycl implements Vehicle {

	int speed;
	int gear;

	@Override
	public void changeGear(int newGear) {
		gear = newGear;
	}

	@Override
	public void speedUp(int increment) {
		speed = speed + increment;
	}

	@Override
	public void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	public void printStates() // this method isn't in interface -- so don't put @override
	{
		System.out.println("speed: " + speed + " gear: " + gear);
	}
}

// multiple inheritance using interface
interface I1 {
	
	// abstract method
	void abs(int i);
	
	// default method
	default void show() {
		System.out.println("Default I1");
	}
}

interface I2 {
	
	// abstract method
	void abs(int i);	
	
	// static method
	static void show() {
		System.out.println("Default I2");
	}
}

// class that implements both interfaces -- kinda similar to class that inherit multiple classes
class Test implements I1, I2 {
	// Overriding show method
	public void show() {
		// use super keyword to call the show method of I1 interface -- no need of super for static methods of interfaces
		I1.super.show();

		// direct call static method of interface -- using Interface name -- no need of reference or something
		I2.show();
	}
	
	@Override
	public void abs(int i) {
		System.out.println("value of i is "+i);
	}
}

// interface that extends(inherit) multiple interfaces -- inheritance in interfaces
interface I3 extends I1, I2 {
	static void showing() { // it is static now
		 
		// I1.super.show(); 
		// -- we can call the default methods in default type method
		// -- we can't call the default methods in static type method
		 
		I2.show(); //-- we can call the static method in any type method
		 
		// we can't make the same named static fn as the inherited interfaces -- ERROR
		System.out.println("Interface I3 that inherited I1, I2");
	}
}

// encapsulation
class encapsulation {
	// private variables declared
	// these can only be accessed by
	// public methods of class
	private String geekName;
	private int geekRoll;
	private int geekAge;

	// get method for age to access
	// private variable geekAge
	public int getAge() {
		return geekAge;
	}

	// get method for name to access
	// private variable geekName
	public String getName() {
		return geekName;
	}

	// get method for roll to access
	// private variable geekRoll
	public int getRoll() {
		return geekRoll;
	}

	// set method for age to access
	// private variable geekage
	public void setAge(int newAge) {
		geekAge = newAge;
	}

	// set method for name to access
	// private variable geekName
	public void setName(String newName) {
		geekName = newName;
	}

	// set method for roll to access
	// private variable geekRoll
	public void setRoll(int newRoll) {
		geekRoll = newRoll;
	}
}

// abstraction
abstract class Shape {
	String color;

	// these are abstract methods
	abstract double area();

	public abstract String toString();

	// abstract class can have constructor
	public Shape(String color) {
		System.out.println("Shape constructor called with color = " + color);
		this.color = color;
	}

	// this is a concrete method
	public String getColor() {
		return color;
	}
}

class Circle extends Shape {
	double radius;

	public Circle(String color, double radius) {
		// calling Shape constructor
		super(color);
		System.out.println("Circle constructor called");
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return ("Circle color is " + super.color + " and area is : " + area());
	}
}

// this -- full
class that {
	int a, b;

	that() {
		this(10, 20); // 1. to call constructor
		System.out.println("inside default constructor");
	}

	that(int a, int b) {
		this.a = a; // 2. to assign values in variables
		this.b = b; // in this way we can assign same named formal variable -- u can see that both names are same
		System.out.println("inside parameterized constructor");
	}

	that get() // return type = class bcoz it returning object of class
	{
		return this; // 3. returning object
	}

	void display() {
		System.out.println("a = " + a + ", b = " + b);
	}

	void getting() {
		print(this); // 4. can be passed as an argument to another method
	}

	void print(that obj) // 4. a fn that recieves 'this' as a parameter
	{
		System.out.println("a = " + a + ", b = " + b); // a = obj.a
	}
}

// method overloading
class Demo {
	public void show(int x) // even if we give 'char' -- it fall into this fn -- it searches for the next
							// higher type -- in terms of size
	{
		System.out.println("In int" + x);
	}

	public void show(String s) {
		System.out.println("In String" + s);
	}

	public void show(byte b) {
		System.out.println("In byte" + b);
	}
}

//showing changing from private to public & vice-versa -- change private to public & vice-versa & see what we can do
//we can use any combination -- except -- public(super) & private(sub) -- ERROR
class main_class {
	@SuppressWarnings("unused")
	private String fun() // private methods can't be overridden -- we can write both as private -- bcoz
							// we can't call private methods in anyway
	{
		return "super fun";
	}

	static void forfun() {
		System.out.println("super's static");
	}
}

class sub_class extends main_class {
	@SuppressWarnings("unused")
	private String fun() {
		return "sub fun";
	}

	static void forfun() {
		System.out.println("sub's static");
	}
}

// nested static v/s non-static class
class OuterClass {
	private static String msg = "GeeksForGeeks";

	// Static nested class
	public static class NestedStaticClass {
		// Only static members of Outer class is directly accessible in nested static class
		public void printMessage() {
			// Try making 'message' a non-static variable, there will be compiler error
			System.out.println("Message from nested static class: " + msg);
		}
	}

	// non-static nested class - also called Inner class
	public class InnerClass {
		// Both static and non-static members of Outer class are accessible in this Inner class
		public void display() {
			System.out.println("Message from non-static nested class: " + msg);
		}
	}
}

class tt{
	static {
		System.out.println("static block called for parent");
	}
	tt(){
		System.out.println("parent constructor");
	}
}

// static block
class Test2 extends tt {
	static int i;
	static int j;
	static {
		i = 10;
		System.out.println("static block called for i");
	}
	static {
		j = 20;
		System.out.println("static block called for j");
	}

	Test2() {
		System.out.println("child constructor");
	}
}

// intializer block 
class GFG {
	int i=5;
	static int j=10;
	// Initializer block starts..
	{
		j+=45;
		i+=2;
		System.out.println(i+j);
		// This code is executed before every constructor.
		System.out.println("IB 1");
	}
	// Initializer block ends

	public GFG() {
		System.out.println("constructor 1");
	}

	public GFG(int x) {
		System.out.println("constructor 2");
	}
	
	{
		System.out.println("IB 2");
	}
}

// intiailzer blocks in inheritance
class B {
	B() { // as the obj of A will be formed -- this class's IB then constructor will be called
		System.out.println("B-Constructor Called");
	}

	{
		System.out.println("B-IB block");
	}

}

class A extends B {
	A() {
		System.out.println("A-Constructor Called");
	}

	{
		System.out.println("A-IB block");
	}
}

// random
class mj {
	int x = 5;

	mj(int i) {
		x = i;
	}
}

// Varargs (variable arguments)
class Test1 {
	// A method that takes variable number of intger arguments.
	// ... = []
	void fun(int... a) {
		System.out.println("Number of arguments: " + a.length);

		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}

	// A method that takes variable number of intger arguments.
	void funn(String... a) {
		for (String i : a)
			System.out.println(i);
	}
}

// method overloading & null
class Test3 {
	public void fun(Integer i) {
		System.out.println("fun(Integer ), value = "+i);
	}

	public void fun(String name) {
		System.out.println("fun(String ), value = "+name);
	}
}

// copy constructor
class CComplex {
	double re, im;

	// A normal parametrized constructor
	public CComplex(double re, double im) {
		System.out.println("main constructor called");
		this.re = re;
		this.im = im;
	}

	// copy constructor
	CComplex(CComplex c) {
		System.out.println("Copy constructor called");
		re = c.re;
		im = c.im;
	}
}

// singleton class
class MySingleton {
	static MySingleton instance = null;
	public int x = 10;

	// private constructor can't be accessed outside the class
	private MySingleton() {
		System.out.println("I'm a singleton");
	}

	// Factory method to provide the users with instances
	static public MySingleton getInstance() // static bcoz we can't call constructor -- this method can be called
											// without obj via class_name
	{ // we will use this method to create objects
		if (instance == null)
			instance = new MySingleton();
		return instance;
	}
}

// main class 
public class Oops {
	
	// constructor
	Oops(String t1) {
		System.out.println("object created named " + t1);
	}

	// java is pass a variable by value -- then actual variable's value won't change
	public static void change(int x) {
		x = 10;
	}

	// here new object will be made i -- that's pointing to the same memory as passed object
	// if we change something of this object then changes will be done in the memory that is the memory of passed object
	public static void change(mj i) {
		i.x = 10;// i.x = 10 permanently
	}

	// new object will be made i and it will be pointing to the same memory as passed object
	// but after i=j,  i will point to j's memory and change will be done in that memory
	// so changes happened in passed object's memory
	public static void changing(mj i) {
		mj j = new mj(30);
		i = j; // i = 5 before -- i= 5 after
	}

	// two objects created that points to two diff memory
	// after swap they will be pointing to diff memory -- swapping happened for these formal objects
	// but what about passed object -- they still pointing to the same memory -- so no swapping for them
	public static void swap(Car c1, Car c2) {
		Car temp = c1;
		c1 = c2;
		c2 = temp;
	}

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {

		// object creation
		Oops obj = new Oops("obj");
		// Java stores objects on heap

		Car c1 = new Car(101, 1);
		Car c2 = new Car(102, 2);
		swap(c1, c2);	// no swapping
		c1.print();
		c2.print();

		// inheritance -- parent_class/super_class/base_class -- child_class/sub_class
		// extends -- keyword used to inherit
		
		// parent's constructor(unparameterized) will be automatically executed before child's -- always
		// -- if parameterized -- then we gotta use super keyword to invoke parent's constructor
		
		// no need of super keyword if parent class's constructor is having no parameters -- otherwise we need to use super
		// -- to call parent's constructor 
		// if both type of constructors are present 
		// -- if u use super then it will call parameterized constructor else unparameterized
		// -- super(parent's constructor's arguments) -- this line must be the first line in the child's constructor
		// that's why we need to pass that no of arguments when creating child's object
		// -- which is equal to parent's class aruguments + child class arg.

		// when we create object of subclass then first constructor(only constructor) of
		// its superclass will be called then it will call constructor of subclass
		// point is -- only the subclass's object is created not the object of super class(implicitly)
		// we can use hashCode() -- to find id of obj -- there will be only be single id --
		// means single object is created
		MountainBike mb4 = new MountainBike(5, 6, 7);
		// hashcode called in both the constructors will be same
		// also when we use -- this.getClass.getName() or getSimpleName() -- in super
		// class -- it will return name of subclass
		// -- bcoz this returns runtime type of instance of this(this of super & sub
		// both) -- super.getClass() = object's getclass
		// -- this.getClass.getSuperclass.getName() -- for super class's name


		// overriding -- a method which is present in both classes(parent & sub) with
		// same name, same parameters, same return type
		
		// -- we can only override methods not variables bcoz they resolve at compile time and methods resolves at runtime
		
		// -- so when we call that method then subclass's method will be called
		// -- gives the ERROR if we give wrong parameters acc. to subclass's method --
		// no overloading concept applied
		// -- means if we try to call overridden method of superclass -- ERROR
		
		
		// referencing subclass object with subclass & superclass reference
		// 1. with subclass
		MountainBike mb1 = new MountainBike(4, 200, 20);
		// in this way, we can access all members of subclass & superclass
		System.out.println(mb1.gear); // superclass variable
		System.out.println(mb1.seatHeight); // subclass variable
		mb1.printing(); // superclass's method

		// 2. with superclass
		Bicycle mb2 = new MountainBike(5, 33, 232);
		// in this way, we can ONLY access methods & variables of superclass &
		// System.out.println(mb2.seatHeight); -- ERROR
		System.out.println(mb2.toString()); // bcoz toString is in both(child and parent) that's why child's will be called

		// Child_class c=new Parent_Class() --- NOT ALLOWED
		
		// the above referencing subclass object with subclass & superclass reference --
		// can only be applied to overridden methods -- not for overridden variables
		// if we access variables of super class -- in 2nd pt. -- then superclass's
		// overridden variable will be called
		System.out.println(mb2.value); // superclass's variable
		// -- bcoz overridden methods resolves at run time
		// -- & overridden variables resolves at compile time

		// overridding is totally related to inheritance concept
		// private/final/static methods can't be overridden
		// constructors can't be overridden
		
		// above mech. = runtime polymorphism
		// private, final and static methods and variables uses static binding and bonded by compiler 
		// -- while overridden methods uses dynamic binding -- runtime based upon type of runtime object
		// so if we make parent's overridden method private/static/final -- then in pt. 2 parent's overridden method
		// will be called since there is no overridding existed
		
		// Java supports --
		// single level
		
		// multi level -- if a method with same name is present in grandparent and parent and child then the child class
// can't call the grandparent's same name method -- it will be called through parent 
// only parent can call its parent's same name method
		
		// -- how to call grandparent's method from grandchild class
		//  super.super.method() -- compile error 
		// super.method() -- for parent's method and then super.method() in parent's method for grandparent's method
		
		// hierarchical -- one class can be parent of many classes

		// Multiple inheritance -- one class inherits multiple class -- not allowed in Java 
		// -- but we can achieve that using interface
		
		// hybrid inheritance -- diamond type -- not supported

		// diamond problem 
		// -- there is grandparent class which is extended by parent1 and parent2 class
		// -- a 4th class which extends parent1 and parent2 both
		// and we have a method fun() which is present in both parent1 and parent2
		// now if we make object of 4th class and call fun method then compiler will be confused that which parent class
		// it should call 
		
		// interface -- blueprint
		// -- suppose a class having only method declarations & constant variable --
		// that showing the overview of class & hides the implementation details
		// interface -- keyword
		// syntax -- interface <name> -- access specifier = public/default -- we can't make interface private or protected
		// {
		// 		variables(public, static, final) -- by default even if we don't specify -- therefore must be intialized 
		// 		methods(public, abstact) -- by default even if we don't specify -- abstract = only declaration not definition
		// }
		// we implement the interface using a class that consists the
		// definition of all the methods of the interface with some of it's methods also
		// -- a class can implement more than one interface
		// -- we need to implement all methods of interface(with public access specifier) in that class bcoz interface
		// tells that all the methods are present that are declared in interface
		// implements -- keyword
		// @override -- use in class that implements the same methods as in interface
		Bicycl bicycle = new Bicycl(); // bicycle = object of class Bicycl that implements interface
		bicycle.changeGear(2); 
		// interface can't have its childrens -- so in this way we can have reference of interface
		bicycle.speedUp(3);
		bicycle.applyBrakes(1);

		// we can also make a default method in interface -- that should not reveal the
		// details of implementation
		bicycle.display(); // this method is defined in interface
		// we need object of class to call default method of interface

		// we can also define a static method in interface -- & no need of object to
		// call that -- call -- interface_name.fn_name();
		Vehicle.disp(); // disp = static method in interface -- Vehicle = Interface
		
		// both default and static methods can have parameters and a return type(like int or float)

		// multiple inheritance using interfaces
		Test t1 = new Test();
		t1.show();

		// inheritance in interfaces -- An interface can also extend one or multiple interfaces
		I3.showing();
		
		// the class(non-abstracted) that implements an interface = object of that interface
		// That_Interface interface = new That_Class() -- CORRECT -- NO ERRORS
		Vehicle v = new Bicycl();

		// final -- use to prevent inheritance and method excessing
		
		// 1. final class -- when we declare a class as final -- then no other can extend it
		// -- all of its methods & variables will be implictly declared as final
		// -- we shouldn't make a abstact class(empty) final, bcoz the subclass supposed
		// to complete implementation -- & it won't happen if we that class final too

		// 2. final methods -- if we make a method final in super class
		// -- then none of its subclass can override that method(declare with same
		// name/parameter/return type) -- we can call but not override

		// 3. final variables -- they are allowed to initialize only once(either at declaration or before first calling)
		// -- we can't use these variables without initialization
		// -- after initilization, we can't change the value of them
				
		// Java resolve calls to methods at run time(late binding)
		// -- but it handle calls to final methods at compile time(early binding)

		// we can't call private methods & data using object of that class -- they are
		// accessible only inside the class(using inner class also)

		// encapsulation -- data binding & hiding(both)
		// data binding -- pack all the variables & methods in single class -- that's what we usually do
		// data hiding -- making class variables privates & methods public
		// public methods -- to set & get the value of the variables
		// private variables -- any other class won't access & user will never know how to values will stored given by him
		// he can only give & get the values -- he can't access & can't see the value of the variables
		encapsulation ob = new encapsulation();
		// setting values of the variables
		ob.setName("Harsh"); // we can only set values of the private variables through the methods bcoz we
								// can't access & see the variables
		ob.setAge(19);
		ob.setRoll(51);
		// Displaying values of the variables
		System.out.println("Geek's name: " + ob.getName());
		System.out.println("Geek's age: " + ob.getAge());
		System.out.println("Geek's roll: " + ob.getRoll());

		// abstraction -- hiding implementation details -- showing only neccessary details

		// abstract class -- which contains only method declaration not definition
		// -- its it subclass responsibililty to implement those methods
		// -- we will only present abstract class -- then user will never know how the methods are implemented
		// abstract class can have both abstract & concrete methods(normal methods)
		// these classes can't have objects -- ERROR
		// but they can have parameterized constructor & default constructor

		// abstract method -- method with only declaration & without definition
		// these methods must be defined in subclass to complete their implementation -- overridden

		// abstract keyword -- to make a class or a method abstract
		// if a class don't have a abstract method but that class is declared with abstract keyword 
		// -- then that class = abstract
		// a class can't inherit multiple abstract classes
		Shape s1 = new Circle("red", 20);
		System.out.println(s1.toString());
		
		// for 100% abstraction -- use interfaces bcoz abstract class can have concrete method 

		// this -- = self in python
		// this = obj inside class
		// this.a = accessing variable a inside class using this
		// this.display() -- accessing method inside class using this
		that t = new that(); // we can also call another constructor, if we want to parameterized it right here
		t.get().display();
		t.getting();

		// method overloading
		// Java supports method overloading(methods with same name and diff parameters) -- in inheritance --
		// return type can be diff/same -- we need same name and diff parameters
		// it will first find the exact method & then it call that method
		// C++ -- doesn't -- in the class
		// what if same typed parameters not present -- Ex. let say, we have parameters = int -- we give char 
		// -- then it will take it
		// -- bcoz if same typed parameters not present -- then it will search for the higher type(in terms of size)
		// -- char --> int
		// -- int --> float
		// -- float --> ERROR
		Demo d = new Demo();
		d.show('a'); // it will be called for int
		d.show("string"); // we have a string type(argument) fn -- so it will be called as normal
				
		// instance v/s static variables and methods
		// -- every object has copy of instance method -- but all objects will share only one static method
		// -- change in one object's instance variable doesn't put any effect of other's instance variable
		// -- since all objects share single static variable -- so change in staic variable
		// = change in all object's static variable
		// -- instance called by obj -- static called by class & object both (no need of
		// object to call them)

		// static method can't use this and super both
		
		// Instance method can access the instance methods and instance variables directly.
		// Instance method can access static variables and static methods directly.
		// Static methods can access the static variables and static methods directly.
		// Static methods can't access instance methods and instance variables directly.
		// They must use reference to object
		// And static method can't use 'this' and 'super' keyword as there is no instance for this
		// to refer to.
		
		// class can be -- public / abstract / final
		// private / static class -- ERROR
		// but inner classes can be static -- nested classes

		// inner(non-staic & static both) class can access private methods & data of outer class -- but not subclass

		// diff b/w nested static & nested non-static
		// 1. we need of obj of outer class to create inner(non) class's method 
		// -- but in inner(static) we don't
		OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass(); // no object of outer class created
		printer.printMessage();
 
		OuterClass outer = new OuterClass(); 
		OuterClass.InnerClass inner = outer.new InnerClass(); // object of inner class created

		OuterClass.InnerClass innerObject = new OuterClass().new InnerClass(); // object of inner class created
		innerObject.display();

		// 2. inner(non) can access static & non-static methods & variables of outer class 
		// -- inner(static) can access only static methods & variables

		
		// object class -- root class of all the classes
		// -- all the classes which don't inherits some class -- inherit object class
		// -- all the clasees which already inherited some class -- inherit this class
		// -- due to inheritance (multi level)

		// methods in object class
		// 1. toString() -- converts an object to string
		// 2. hashcode() -- returns unique no to every object -- not the address -- it
		// converts the address into some integer which will be unique
		// 3. equal(given obj) -- compare given obj to 'this'
		// 4. obj.getClass() -- returns the class of 'this' object
		// 5. clone() -- return a copy of given obj
		// 6. finalize() -- called just before the garbage collector -- to dispose
		// system resources, perform clean-up activities and minimize memory leaks
		
		// Object class's variables = python variables -- we can assign any type of
		// value in an variable just after the one another
		Object y;
		
		y = 'A';
		System.out.println(y.getClass().getName());

		y = 1;
		System.out.println(y.getClass().getName());

		y = "Hi";
		System.out.println(y.getClass().getName());

		y = 1.222;
		System.out.println(y.getClass().getName());

		y = false;
		System.out.println(y.getClass().getName());
		
		// static block -- no name/ no return type/ no parameters only static and then a block
		// the block of code will be executed only once of all obj -- bcoz of the static
		// they will be called before constructor -- but only once of all objects
		// we can make as many no of static blocks as we want
		// they can access only static members of the class
		Test2 om = new Test2();

		// intializer block - IB
		// -- a block without any return type , name , parameters -- only opening &
		// closing braces -- & some code inside it -- that will execute for every obj
		// -- need -- when we have diff constructors then the code of constructor will
		// change on the basis of constructor calling
		// -- in this we want that some code execute for every obj -- doesn't matter
		// which constructor will be called
		// they will be execute before constructor(any constructor)
		// it doesn't matter where they are wriiten(above or below of constructor)
		// can access any member of the class(static or non-static)
		GFG ob1 = new GFG();
		GFG ob2 = new GFG(10);

		// if we've multiple these blocks -- they will be execute from top block to bottom block
		// the superclass's IB will be called just as the obj of subclass's formed --
		// before constructor of superclass -- before sub's constructor & IB
		A a = new A();

		// addition v/s concatenation
		// -- first it will add, after the encounter with string, it will concatenate
		System.out.println(2 + 0 + 1 + 6 + "GeeksforGeeks"); // 9GeeksforGeeks
		System.out.println("GeeksforGeeks" + 2 + 0 + 1 + 6); // GeeksforGeeks2016
		System.out.println(2 + 0 + 1 + 6 + "GeeksforGeeks" + 2 + 0 + 1 + 6); // 9GeeksforGeeks2016
		System.out.println(2 + 0 + 1 + 6 + "GeeksforGeeks" + (2 + 0 + 1 + 6)); // 9GeeksforGeeks9 -- due to precedance
																				// of () over +

		// if we pass a variable -- then actual variable's value won't change
		int xx = 5;
		change(xx);
		System.out.println(xx);

		// but if we pass a class obj then the changes can also be seen in obj even after this method
		mj xx1 = new mj(5);
		change(xx1);
		System.out.println(xx1.x);

		mj xx2 = new mj(5);
		changing(xx1);
		System.out.println(xx2.x);

		// if we pass two Integer obj for swapping -- then they won't be swapped -- bcoz
		// Integer obj is (int > obj)

		// we can return multiple values using -- pair / list(Java list = python list)

		// main method
		// public: JVM can execute the method from anywhere.
		// static: Main method can be called without object.
		// void: The main method doesn't return anything.
		// main(): Name configured in the JVM.
		// String[]: Accepts the command line arguments.

		// 1. switch static & public
		// 2. write sq. brackets at any position
		// a. after & near String
		// b. before & near args
		// c. after & near args
		// d. replace it with ' ... ' -- NO ERROR works fine

		// 3. we can make method final -- public final static void main(..)

		// 4. we can make String args final -- final String[] args

		// 5. overloading of main method -- String[] args / int[] args -- NO ERROR

		// Variable arguments(Varargs) -- same as *args & **kwargs in python
		// formal arg. == int... a --> now type(a) = array -- bcoz of int
		// we can make type = anything then type of a = array
		// rules are same as python args
		// ... = []
		Test1 ab = new Test1();
		ab.fun(5);
		ab.fun(1, 2, 3, 4); // array of int
		ab.fun(1, 2, 3);

		// here type of a = array of strings
		ab.funn("ravi", "kant");

		// method overloading & null
		Test3 t3 = new Test3();
		// t3.fun(null); -- we can't do this - ERROR -- bcoz Integer & String both
		// accepts -- so parameters will be same -- compiler get confused

		Integer arg = null;
		t3.fun(arg); // now Integer will be called, value = null

	 	// System.exit(0) -- to terminate program
		// -- exit(0) -- to show a successful submission
		// -- exit(1 or -1) -- to show an unsuccessful submission

		// copy constructor -- to create a copy of an obj
		CComplex cd = new CComplex(12, 14); // main constructor will be called
		CComplex cd1 = cd; // copy constructor will be called
		
		// both will be pointing to same memory
		cd.im=232;
		System.out.println(cd.im);
		System.out.println(cd1.im);
		cd1.re=1212;
		System.out.println(cd.re);
		System.out.println(cd1.re);
				
		// if we don't make a copy constructor -- Java won't create that implicitly --
		// then ERROR if we create an obj using another obj

		// singleton class -- class that can have only one obj
		// for this -- we've to make constructor private -- so that constructor can be
		// called only inside the class -- otherwise one can create multiple obj
		// & a static obj inside the class -- once it set to a obj -- no other can be created
		MySingleton omg = MySingleton.getInstance();
		MySingleton omg1 = MySingleton.getInstance(); // both will point out same obj -- this class can have only one obj
		MySingleton omg2 = MySingleton.getInstance();
		omg.x = omg.x + 10;
		System.out.println("Value of omg.x = " + omg.x);
		System.out.println("Value of omg1.x = " + omg1.x);
		System.out.println("Value of omg2.x = " + omg2.x);

		// access modifier -- see the image below WrapperClass for their scope
		// 1. Default -- When no access modifier is specified for a class , method or data member 
		// -- It is said to be having the default access modifier by default
		// -- accessible only within the same package.
		
		// 2. Private -- accessible only within the class in which they are declared
		// Any other class of same package will not be able to access these members
		// also subclasses can't access private members of parent class
		
		// 3. Protected -- accessible within same package or sub classes in different package
		// means subclasses can access private members of the parent class
		
		// 4. Public -- accessible from every where in the program
		// -- there is no restriction on the scope of a public data members
		
	}
}