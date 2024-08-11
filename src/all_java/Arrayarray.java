package all_java;

import java.util.Arrays; // for all Array methods
import java.util.Comparator; // for comparator

// array of objects
class Student {
	public int roll_no;
	public String name;

	Student(int roll_no, String name) {
		this.roll_no = roll_no;
		this.name = name;
	}
}

// for comparative sorting
class Studnt {
	int rollno;
	String name, address;

	// Constructor
	public Studnt(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

// sorting by roll no
class Sortbyroll implements Comparator<Studnt> {

	// Used for sorting in ascending order of
	// roll number
	public int compare(Studnt a, Studnt b) {
		return a.rollno - b.rollno;
	}
}

// understanding final
class Testtype {
	int p = 20;
}

// main class
public class Arrayarray {
	public static void increment(int[] a) { // this array also points to the same memory as passed array 
		// -- so change will occur in both
		for (int i = 0; i < a.length; i++)
			a[i] += 1;

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// we've to give length --> not like vector
		// we can't change size, if we do that the old array would be gone & in the
		// identifier new array will be assigned
		// static -- bcoz of above reason

		// declaration
		// 1. type[] name
		int[] aa;
		// 2. type name[]
		char b[];

		// creation -- new int[size];
		aa = new int[5];

		// both
		String[] c = new String[10];

		// declaration + creation + intialization
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(aa.length);

		int[] ab = { 1, 2, 3, 4, 5 };
		System.out.println(ab.length);

		// default values
		// 1. 0 -- for int / float / double
		// 2. null -- for String / for reference type(object of a class)
		// 3. false -- boolean
		// 4. null char -- for char

		// excessing elements using for loop
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
		// using for-each loop
		for (int i : a)  // here i = value of each element of a, it's not pointing
			i=i+5;		 // if we change value of i -- elements of a won't change
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();

		// array of objects of a class
		Student[] arr = new Student[3]; // array of size 3 -- each element = obj of class Student

		// intializing elements
		arr[0] = new Student(1, "aman");
		arr[1] = new Student(2, "vaibhav");
		arr[2] = new Student(3, "shikar");

		for (int i = 0; i < arr.length; i++)
			System.out.println("Element at " + i + " : " + arr[i].roll_no + " " + arr[i].name);

		// passing & returning array into a method
		for (int i : a)
			System.out.print(i);
		System.out.println();
		
		increment(a);	// array will be changed
		
		for (int i : a)
			System.out.print(i);
		System.out.println();

		// to get class
		System.out.println(a.getClass());
		// System.out.println(b.getClass()); -- b is not initialized -- we can't get it
		// class
		System.out.println(c.getClass());

		// cloning -- creating duplicates
		// deep copy -- change in one != same change in another --- points to diff memory
		int cloneArray[] = a.clone();
		System.out.println("a[0] = " + a[0] + " clone[0] = " + cloneArray[0]);
		cloneArray[0] = 100;
		System.out.println("a[0] = " + a[0] + " clone[0] = " + cloneArray[0]);

		// shallow copy -- change in one = same change in another
		int cloneArray2[] = a;
		System.out.println("a[0] = " + a[0] + " clone[0] = " + cloneArray2[0]);
		cloneArray2[0] = 100;
		System.out.println("a[0] = " + a[0] + " clone[0] = " + cloneArray2[0]);

		
		// Arrays methods
		// 0. Arrays.toString(arr) -- convert whole array in one line -- [a0, a1, a2,
		// ...] -- type of o/p = String -- "[...]"
		System.out.println(Arrays.toString(a));

		// 1. sort(arr)
		a[0] = 200;
		a[1] = 50;
		// a. direct sort -- non-decreasing sort
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// b.sort(arr, start, end) -- sort non-decreasingly from start to end-1
		a[0] = 400;
		a[1] = 30;
		Arrays.sort(a, 0, 2);
		System.out.println(Arrays.toString(a));

		// c. using some comparator
		Studnt[] arr1 = { new Studnt(111, "bbbb", "london"), new Studnt(131, "aaaa", "nyc"),
				new Studnt(121, "cccc", "jaipur") };
		// three objects -- nothing more
		// before sorting
		for (Studnt obj : arr1)
			System.out.println(obj);

		Arrays.sort(arr1, new Sortbyroll());

		// after sorting -- according to roll no
		for (Studnt obj : arr1)
			System.out.println(obj);
		// we can also give range -- sort(arr, start, end, new Sortbyroll()) -- sort
		// from start to end-1

		// 2. binarySearch(arr, [fromIndex], [toIndex], key) -- searches key in a
		// range(if given) -- returns -ve no if not found
		System.out.println("200 found at index = " + Arrays.binarySearch(a, 200));
		System.out.println("200 found at index = " + Arrays.binarySearch(a, 0, 2, 6));

		// 3. compare(arr1, arr2) -- returns 1 if all elements are of smaller length
		// present in greater length array, otherwise -1
		// it ignores sign -- 40 = -40 -- compares abs values
		int[] a1 = { 3, 2, 5, 4, 1 };
		int[] a2 = { 2, 4, -3 };
//		System.out.println(Arrays.compare(a1, a2)); // 1
		a2[0] = 200;
//		System.out.println(Arrays.compare(a1, a2)); // -1

		// 5. copyOf(arr, len) -- returns new array
		// if given len > arrayLength -- then it will padd 0 after array elements upto
		// given length
		// if gievn len < arrayLength -- then it will delete elements from last to make
		// length equal
		System.out.println(Arrays.toString(Arrays.copyOf(a, 10)));
		System.out.println(Arrays.toString(Arrays.copyOf(a, 2)));

		// 6. copyOfRange(arr, start, end) -- returns new array from start to end-1
		System.out.println(Arrays.toString(Arrays.copyOfRange(a, 1, 4)));

		// 7. equals(arr1, arr2) -- returns true if all elements of both array matches
		// corresponding indexes
		System.out.println(Arrays.equals(a1, a2));

		// 8. mismatch(arr1, arr2) -- returns first index where elements get unequal
//		System.out.println(Arrays.mismatch(a1, a2));

		// final int[] arr; --> final arrays
		// -- we can change elements
		// -- arr can't point to some other array
		final int arrb[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 10, 20, 30, 40, 50 };
		// arrb = arr2; -- ERROR
		arrb[0] = 100;
		System.out.println(Arrays.toString(arrb));

		// class ex.
		final Testtype t1 = new Testtype();
		Testtype t2 = new Testtype();
		// t1 = t2; -- ERROR -- we can't assign final element to some other element of
		// same type
		System.out.println(t1.p); // we can change elements bcoz p != final

		// 2-D -- same as 2-D vector -- but same as row, we've to assign size of each
		// col also
		int[][] d2 = new int[3][];
		System.out.println(d2.length); // prints no of rows

		// allocation size for each row --
		for (int i = 0; i < d2.length; i++) // assigning size of each col
			d2[i] = new int[i + 1];

		// entering elements
		int count = 0;
		for (int i = 0; i < d2.length; i++)
			for (int j = 0; j < d2[i].length; j++)
				d2[i][j] = count++;

		// printing elements
		for (int i = 0; i < d2.length; i++) {
			for (int j = 0; j < d2[i].length; j++)
				System.out.print(d2[i][j] + " ");
			System.out.println();
		}

		// 3-D
		int[][][] d3 = new int[3][3][3];
	}
}
