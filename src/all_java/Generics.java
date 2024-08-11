package all_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// parameters to class
class genericClass<T> 
{
	 // An object of type T is declared, if Integer is passed then T = Integer
	 T obj;  
	 genericClass(T obj) {  this.obj = obj;  }  // T obj(argument) = new T(value passed) -- that's how it will recieve
	 public T getObject()  { return this.obj; } 
}

// multiple parameters to class
class multiGenericClass<T, U> 
{ 
    T obj1;  // An object of type T 
    U obj2;  // An object of type U 
  
    // constructor 
    multiGenericClass(T obj1, U obj2) 
    { 
        this.obj1 = obj1; 
        this.obj2 = obj2; 
    } 
  
    // To print objects of T and U 
    public void print() 
    { 
        System.out.println(obj1); 
        System.out.println(obj2); 
    } 
} 

public class Generics {
	
	// A Generic method example -- this will take parameter of any type
    static <T> void genericMethod1 (T element) 
    { 
        System.out.println(element.getClass().getName() + " = " + element); 
    } 
    
    // this will take argument of ArrayList only with any type of data type
    static <T> void genericMethod2 (ArrayList<T> element) 
    { 
        System.out.println(element.getClass().getName() + " = " + element); 
    }
	
    // wildcard method -- take argument of List only with any data type
    // 1. wildcard = unknown
    private static void printlist(List<?> list)  
    { 
  
        System.out.println(list); 
    } 
    
    // wildcard method -- take argument of List only with Number / Double / Intger
    // 2. wildcard = upper bound
    private static double sum(List<? extends Number> list)  
    { 
        double sum=0.0; 
        for (Number i: list) 
        { 
            sum+=i.doubleValue(); // we have used double values -- bcoz we can pass data of type Double
        } 
  
        return sum; 
    }
    
    // wildcard method -- take argument of List only with the data type which are superclass of Integer and Integer itself
    // 2. wildcard = lower bound
    public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list) 
    { 
        System.out.println(list); 
    } 
    
	public static void main(String[] args) {
		
		// The idea is to allow type(Integer, String, etc and user defined types) to be a parameter to a method,
		// -- classes and interfaces
		// use -- < > -- to specify type
		
		// instance of Integer type -- genericClass = a generic class
		genericClass<Integer> iObj = new genericClass<Integer>(40); 
        System.out.println(iObj.getObject()); 
        
		genericClass<Integer> iObj1 = new genericClass<Integer>(40); 
        System.out.println(iObj.getObject()); 
   
        if(iObj==iObj1) // not equal
        	System.out.println("kjbjh");
        
        // instance of String type 
        genericClass<String> sObj = new genericClass<String>("GeeksForGeeks"); 
        System.out.println(sObj.getObject());
        
        // multiple parameters -- String & Integer
        multiGenericClass<String, Integer> ob1 = new multiGenericClass<String, Integer>("GfG", 15); 
        ob1.print(); 
        
        // now Integer & String
        multiGenericClass<Integer, String> ob2 = new multiGenericClass<Integer, String>(15, "GfG"); 
        ob2.print(); 
        
        // a generic method
        // Calling generic method with Integer argument 
        genericMethod1(11); 
   
        // Calling generic method with String argument 
        genericMethod1("GeeksForGeeks"); 
   
        // Calling generic method with double argument 
        genericMethod1(1.0); 
        
        
        // Advantages
        // 1. Code Reuse: We can write a method/class/interface once and use for any type we want
        // 2. Type Safety : Generics make errors to appear compile time than at run time
        // -- if we make ArrayList without any type -- then it will any type of data in the list -- but what if we want only strings
        // -- if we mention generic type as String -- then it will show ERROR if we add another type of data in the list
        
        
        // it is the generic method which takes the ArrayList only with any type of data type
        ArrayList<Integer> arrli = new ArrayList<Integer>(10); 
        for (int i=1; i<=10; i++) 
            arrli.add(i); 
        genericMethod2(arrli);
        
        ArrayList<String> arrli1 = new ArrayList<String>(10); 
        for (int i=1; i<=10; i++) 
            arrli1.add("A");
        genericMethod2(arrli1);
        
        // this won't take LinkedList 
        LinkedList<Integer> arrli2 = new LinkedList<Integer>();         
        for (int i=1; i<=10; i++) 
            arrli2.add(i); 
        // uncomment the below the line -- ERROR
//      	genericMethod2(arrli2);
        

        // wildcards = ? -- represents an unknown type 
        
        // types 
        // 1. unbounded wildcards -- we can pass argument of any data type
        // Integer List 
        List<?> list1= Arrays.asList(1,2,3); 
        printlist(list1); 
        
        // Double list 
        List<?> list2=Arrays.asList(1.1,2.2,3.3); 
        printlist(list2); 
        
        // Numberlist 
        List<?> list3=Arrays.asList(1.1,2.2,3.3); 
        printlist(list3); 
        
        // mixed
        List<?> list4=Arrays.asList(1,2.2,"ravi"); 
        printlist(list4); 
        
        
        // 2. Upper Bounded Wildcards -- 
        // syntax -- private static double sum(List<? extends Number> list)
        // this way -- we can pass data of type -- Number / Integer / Double
        // bcoz Integer & Double -- are the subclasses of Number
        List<Integer> l1= Arrays.asList(1,2,3); 
        List<Double> l2=Arrays.asList(1.1,2.2,3.3); 
        List<Number> l3=Arrays.asList(1.1,2.2,3.3); 
        System.out.println(sum(l1));
        System.out.println(sum(l2));
        System.out.println(sum(l3));
        
        // 2. Lower Bounded Wildcards -- 
        // syntax -- private static double sum(List<? super Integer> list)
        // this way -- we can pass data of type which are super class of Integer & Integer itself -- Number / Integer 
        // we can't pass Double bcoz Double != super class of Integer
        printOnlyIntegerClassorSuperClass(l1);
        printOnlyIntegerClassorSuperClass(l3);
        // uncomment -- ERROR -- we can't pass Double
//        printOnlyIntegerClassorSuperClass(l2);
        
	}
}
