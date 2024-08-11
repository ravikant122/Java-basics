package all_java;

public class WrapperClass {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// Primitive datatype = int/char/float etc. = normal data type
		// wrapper class = wraps the primitve data type & make it an object
		// to convert primitive data type into object -- we need wrapper class -- 
		// bcoz data structure of collection stores only objects
		// ex. ArrayList<Integer> -- correct
		// not ArrayList<int> -- wrong
		// and classes in java.util handles only objects 
		
		
		// autoboxing -- conversion of primitive data type to their corresponding wrapper classes
		// unboxing -- conversion of wrapper classes to their corresponding primitive data types
		
		
		//  byte data type 
        byte a = 1; 
  
        // wrapping around Byte object 
        Byte byteobj = new Byte(a); 
  
        // int data type 
        int b = 10; 
  
        //wrapping around Integer object 
        Integer intobj = new Integer(b); 
        intobj+=1;
        System.out.println(intobj);
        System.out.println(b); 	// both pointing to diff memory
  
        // float data type 
        float c = 18.6f; 
  
        // wrapping around Float object 
        Float floatobj = new Float(c); 
  
        // double data type 
        double d = 250.5; 
  
        // Wrapping around Double object 
        Double doubleobj = new Double(d); 
  
        // char data type 
        char e='a'; 
  
        // wrapping around Character object 
        Character charobj=new Character(e); 
  
        //  printing the values from objects 
        System.out.println("Values of Wrapper objects (printing as objects)"); 
        System.out.println("Byte object byteobj:  " + byteobj); 
        System.out.println("Integer object intobj:  " + intobj); 
        System.out.println("Float object floatobj:  " + floatobj); 
        System.out.println("Double object doubleobj:  " + doubleobj); 
        System.out.println("Character object charobj:  " + charobj); 
  
        // objects to data types (retrieving data types from objects) 
        // unwrapping objects to primitive data types 
        byte bv = byteobj; 
        int iv = intobj; 
        float fv = floatobj; 
        double dv = doubleobj; 
        char cv = charobj; 
  
        // printing the values from data types 
        System.out.println("Unwrapped values (printing as data types)"); 
        System.out.println("byte value, bv: " + bv); 
        System.out.println("int value, iv: " + iv); 
        System.out.println("float value, fv: " + fv); 
        System.out.println("double value, dv: " + dv); 
        System.out.println("char value, cv: " + cv); 
		
        
        // what happened:
        // 1. it got unboxed & value assigned to normal int
        // 2. value incremented
        // 3. new Integer object is created & autoboxed the int to that Integer object
        // 4. reference of i assigned to new Integer ( i = pointing to new Integer )
        
        // but old Integer object is still there, only reference of i got change
		
	}

}
