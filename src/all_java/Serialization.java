package all_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int a;
    public String b;

    // Default constructor
    public Person(int a, String b)
    {
        this.a = a;
        this.b = b;
    }

}

public class Serialization {
	public static void main(String[] args) {
		// Serliazation means writing object into file in the form of byte array so that we can read it
		// when we need it
		
		/*
		 	why we need it
		 	1. 	we can store the object's data into database and then retrieve from it and then create object
		 		but its slower than serialization, making object from reading from a file is very fast
		 	2. 	serialization can be done on diff JVMs and on diff machine
		 	3.  serialization create the deep copy, so you don't to override clone method
		 	4. 	
		 */
		
		// static and transient variables won't be in serialization
		
		Person object = new Person(1, "geeksforgeeks");
        String filename = "serialize.txt";
        // Serialization 
        try {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            // Method for serialization of object
            out.writeObject(object);
            
            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }


        Person object1 = null;
        // Deserialization
        try {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            
            // Method for deserialization of object
            object1 = (Person)in.readObject();
            
            in.close();
            file.close();
            
            System.out.println("Object has been deserialized");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught&");
        }
	}
}
