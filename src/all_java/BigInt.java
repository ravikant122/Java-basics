package all_java;

import java.math.BigInteger;

public class BigInt {
	
	// demostration method
	static BigInteger factorial(int N) 
    { 
        // Initialize result 
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE 
  
        // Multiply f with 2, 3, ...N 
        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    }
	
	public static void main(String[] args) {
		
		// BigInteger -- we can store as large Integer as we want in it -- no limit
		// memory will be allocated dynamically
		// internally uses Arrays -- so TC of mathematically operation will not be constant
		
		System.out.println(factorial(20));
		
		// Declaration
		int a, b;                
		BigInteger A, B;
		
		// Initialization:
		a = 54;
		b = 23;
		A  = BigInteger.valueOf(54);
		B  = BigInteger.valueOf(37);
		System.out.println(a);
		System.out.println(b);
		System.out.println(A);
		System.out.println(B);
		
		// some constants 
		A = BigInteger.ONE;
		System.out.println(A);
		A = BigInteger.ZERO;
		System.out.println(A);
		A = BigInteger.TEN;
		System.out.println(A);
		
		// Extraction of value from BigInteger:
		int x   =  A.intValue();   // value should be in limit of int x
		System.out.println(x);
		long y   = A.longValue();  // value should be in limit of long y
		System.out.println(y);
		String z = A.toString();
		System.out.println(z);
		
		// mathematical operation
		// 1. A.add(B) -- A+B = NOT allowed
		int c = a + b;
		System.out.println(c);
		BigInteger C = A.add(B); 
		System.out.println(C);
		
		// 2. A.subtract(B)
		c = a - b;
		System.out.println(c);
		C = A.subtract(B); 
		System.out.println(C);
				
		// 3. A.multiply(B)
		c = a * b;
		System.out.println(c);
		C = A.multiply(B); 
		System.out.println(C);
				
		// 4. A.divide(B)
		c = a / b;
		System.out.println(c);
		C = A.divide(B); 
		System.out.println(C);
		

		// Comparison: -1 = less than , 0 = equal , 1 = greater than
		if (A.compareTo(B) < 0) {
			System.out.println("A < B");
		} 
		if (A.compareTo(B) > 0) {
			System.out.println("A > B");
		} 
		if (A.compareTo(B) == 0) {
			System.out.println("A = B");
		} 
		
		A=B; // after this both still points to diff memory
		// for equality
		if (A.equals(B)) {
			System.out.println("A is equal to B");
		}  
		
		// for methods -- go to GFG
		
	}
}
