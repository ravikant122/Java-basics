package all_java;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class InputAndOutput {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		// scanner class = to take input
		// 1. create an object of scanner class -- use pre-defined object - System.in --
		// use obj of a file -- to read data form a file
		// 2. now use that obj to take all type of input -- string/int/float/char
		// 3. to read data of type X -- use nextX() -- for short -- nextShort()
		// 4. for string = nextLine()
		// 5. for char = next().charAt(0)

		Scanner sc = new Scanner(System.in);

		// string
		String name = sc.nextLine();
		System.out.println(name);

		// int
		int x = sc.nextInt();
		System.out.println(x);
		long y = sc.nextLong();
		System.out.println(y);
		
		// for bigint
		BigInteger bi = sc.nextBigInteger();
		System.out.println(bi);

		// float and double
		float f = sc.nextFloat();
		System.out.println(f);
		double z = sc.nextDouble();
		System.out.println(z);

		// char
		char c = sc.next().charAt(0); // this can also take string -- but returns only the first char
		System.out.println(c);

		// this will take only int type data as many as user enters -- as user enters
		// data of some diff type -- loop will be terminated
		int sum = 0, count = 0;
		// Check if an int value is available
		while (sc.hasNextInt()) {
			// Read an int value
			int num = sc.nextInt();
			sum += num;
			count++;
		}
		int mean = sum / count;
		System.out.println("Mean: " + mean);

		// similarly we can take any type of data -- hasNextLine - for string --
		// hasNextfloat - for float

		sc.close();
	}
}
