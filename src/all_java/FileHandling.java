package all_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) throws IOException {
		
		// file creation	
		File myObj = null;
		try {
			// Creating an object of a file
			myObj = new File("src\\all_java\\text1.txt"); 

			if (myObj.createNewFile()) { // returns true if newly created
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		// check file exist or not & get file info 
		if (myObj.exists()) {
			 // Returning the file name
			System.out.println("File name: " + myObj.getName());
			 
			// Returning the path of the file 
			System.out.println("Absolute path: " + myObj.getAbsolutePath());   
			 
			// Displaying whether the file is writable
			System.out.println("Writeable: " + myObj.canWrite());  
			 
			// Displaying whether the file is readable or not
			System.out.println("Readable " + myObj.canRead());  
			 
			// Returning the length of the file in bytes
			System.out.println("File size in bytes " + myObj.length());  
		} else {
			System.out.println("The file does not exist.");
		}
		
		
		// write to file
		// FileWriter -- creates the output file , if it is not present already
		// constructors -- 
		// a. FileWriter(File file, boolean append) -- append value shows that whether or not to append the data written
		// -- if true then it will append the new data 
		// -- if false or not given then it will erase old data & write new data from starting
		// b. FileWriter(String fileName, Boolean append)
		// c. FileWriter(FileDescriptor fd)
		// if boolean append = not given -- that will be treated as false
		try {
			
			// this will erase everything in the file & then write from scratch
			FileWriter myWriter = new FileWriter("src\\all_java\\text1.txt",true);
			myWriter.write("Java is the prominent programming language of the millenium!\n"); 
			
			// write(string, offset, length) 
			// -- offset = starting index in string from which we've to write 
			// -- length = no of chars to write
			myWriter.write("dnfkjdngkjfndkgnkdjngkj!",3,5); 
			 
			// Closing is necessary to retrieve the resources allocated
			myWriter.close(); 
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		// diff ways of reading from a file
		
		// 1. FileReader -- reads char by char -- return ASCII value of char -- after the end returns -1
		System.out.println("\nReading using FileReader");
		FileReader fr = new FileReader("src\\all_java\\text1.txt"); 
		int i; 
		while ((i=fr.read()) != -1) 
			System.out.print((char) i); 
		fr.close();
		// another method of FileReader -- skip(n) -- skip first n char then start reading

		// 2. Scanner 
		// a. with loop
		System.out.println("\n\nReading using Scanner with loop");
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		// b. without loop
		System.out.println("\nReading using Scanner without loop");
		try {
			Scanner myReader = new Scanner(myObj);
			myReader.useDelimiter("\\Z");
			System.out.println(myReader.next());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		// 3. BufferReader
		BufferedReader br = new BufferedReader(new FileReader(myObj));
		
		// a. line by line
		System.out.println("\nReading using BufferReader Line by Line");
		String st;
		while ((st = br.readLine()) != null) 
			System.out.println(st);
		br.close();
		
		// b. char by char
		System.out.println("\nReading using BufferReader char by char");
		br = new BufferedReader(new FileReader(myObj));
		while ((i= br.read()) != -1) 
			System.out.print((char)i);
		br.close();
		
		// 4. file data as String
		String data = "";
		data = new String(Files.readAllBytes(Paths.get("src\\all_java\\text1.txt")));
	    System.out.println("\n\nReading file data as string");
		System.out.println(data); 

		
		// file permissions
		// executable/readable/writable
        // checking
		System.out.println("Executable: " + myObj.canExecute()); 
        System.out.println("Readable: " + myObj.canRead()); 
        System.out.println("Writable: "+ myObj.canWrite()); 
		
        // set -- will work if programmer = main user of ProtocolUtilities
        myObj.setExecutable(false); 
        myObj.setReadable(false); 
        myObj.setWritable(true); 
        System.out.println("Executable: " + myObj.canExecute()); 
        System.out.println("Readable: " + myObj.canRead()); 
        System.out.println("Writable: "+ myObj.canWrite()); 
		
	}
}
