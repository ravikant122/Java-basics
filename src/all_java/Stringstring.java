package all_java;

import java.util.StringTokenizer; // for tokenizing a string

public class Stringstring {
	public static void main(String[] args) {
		
		// String = a class not primitive datatype 
		// if we don't make Strings by -- new String() -- then java does this implicitly
		// String -- immutable / non-extendable
		// creation methods
		// 1. simplest
		String str = "hello world, it's RK";
		System.out.println(str);
		
		str="hello\nhello";	// to put a new line char in string
		System.out.println(str);
		

		// 2. using new -- bcoz String = built-in class in Java
		String s_new = new String("hello");
		System.out.println(s_new);

		// 3. from byte array -- encode byte values into chars
		byte[] b_arr = { 71, 101, 101, 107, 115 };
		String s_byte = new String(b_arr, 2, 3); // firstArg = StartIndex , secondArg = Length
		System.out.println(s_byte);
		// for full array conversion -- don't give StartIndex & Length

		// 4. from char array
		char char_arr[] = { 'G', 'e', 'e', 'k', 's' };
		String s_char = new String(char_arr);
		System.out.println(s_char);

		// 5. from StringBuffer
		StringBuffer buffer = new StringBuffer("Geeks");
		String s_buffer = new String(buffer);
		System.out.println(s_buffer);
		// same for StringBuilder

		// String Methods
		// 1. length()
		"hello".length();
		System.out.println(str.length());

		// 2. charAt(index) -- returns char at given index
		System.out.println(str.charAt(2));

		// 3. substring(startIndex,endIndex) -- returns substring from start to end-1
		System.out.println(str.substring(4, 9));
		// for no endIndex -- till the end

		// 4. str1.concat(str2) -- return str1+str2
		System.out.println(str.concat("geekforgeeks"));

		// 5. indexOf(str) -- returns the index of first occurance of given string
		// if given string not present -- -1
		System.out.println(str.indexOf("it's"));
		// lastIndexOf(str) -- returns the index of last occurance of given string
		// if given string not present -- -1
		System.out.println(str.lastIndexOf("it's"));

		// 6. == --> compares two strings
		System.out.println(str == s_byte);
		// str1.equals(str2) -- returns true or false
		System.out.println(str.equals(s_byte));
		// str1.equalsIgnoreCase(str2) -- ingnore the case
		System.out.println(str.equalsIgnoreCase(s_byte));

		// 7. str1.compare(str2) -- return 0 if equal, 1 if str1 > str2, -1 if str1 <
		// str2
		System.out.println("aa".compareTo("ab"));
		// compareToIgnoreCase -- with case ignoring

		// 8. str.toLowerCase() -- convert string to lowercase
		// 9. str.toUpperCase() -- convert string to uppercase
		// 10. str.trim() -- removes the spaces from both the ends

		// 11. str.replace(str1,str2) -- replaces all occurance of str1 with str2
		System.out.println(str.replace('e', 'M'));
		System.out.println(str.replace("hello", "SirJi"));

		// StringBuffer -- muttable / extendable
		// creation methods
		// 1.
		StringBuffer sb = new StringBuffer("my name is don");
		System.out.println(sb);

		// 2. this will allocate 16 chars String -- but empty
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1);

		// 3. this will reserve 10 chars string -- but empty
		StringBuffer sb2 = new StringBuffer(10);
		System.out.println(sb2);

		// StringBuffer methods
		// 1. length() -- returns size
		// 2. capacity() -- returns total allocated space

		// 3. append(str / int) -- we can give both string or int
		sb.append(" don don don");
		sb.append(1);
		System.out.println(sb);

		// 4. insert(index, str / int/ char / boolean / double / float / charArray)
		StringBuffer s = new StringBuffer("GeeksGeeks");
		s.insert(5, "for");
		System.out.println(s); // returns GeeksforGeeks

		s.insert(0, 5);
		System.out.println(s); // returns 5GeeksforGeeks

		s.insert(3, true);
		System.out.println(s); // returns 5GetrueeksforGeeks

		s.insert(5, 41.35d);
		System.out.println(s); // returns 5Getr41.35ueeksforGeeks

		s.insert(8, 41.35f);
		System.out.println(s); // returns 5Getr41.41.3535ueeksforGeeks

		char geeks_arr[] = { 'p', 'a', 'w', 'a', 'n' };
		// insert character array at offset 9
		s.insert(2, geeks_arr);
		System.out.println(s);

		// 5. reverse() -- reverse the string -- it actually reverse the string
		s.reverse();
		System.out.println(s);

		// 6. delete(start,end) -- deletes char from start to end
		s.delete(0, 5);
		System.out.println(s);

		// 7. deleteCharAt(index) -- delete char at given index
		s.deleteCharAt(0);
		System.out.println(s);

		// 8. replace(start, end, str) -- from start to end-1
		s.replace(0, 2, "ab");
		System.out.println(s);
		// first, substring from start to end-1 will be removed then str will be placed
		// so no matter of length of str -- substring from start to end-1 will be surely
		// removed
		s.replace(0, 2, "aaya");
		System.out.println(s);

		s.replace(0, 3, "a");
		System.out.println(s);

		// 9. appendCodePoint(int cp) -- append the char at ASCII value cp
		s.appendCodePoint(43);
		System.out.println(s);

		// 10. charAt(index) -- return char at given index
		System.out.println(s.charAt(5));

		// 11. indexOf(str, [fromIndex]) -- return the index of first occurance from
		// fromIndex(included)(if this is given)
		// if given string not present -- -1
		System.out.println(s.indexOf("53"));
		System.out.println(s.indexOf("53", 8));
		// lastIndexOf(str,[fromIndex]) -- return till fromIndex(included)
		System.out.println(s.lastIndexOf("53"));
		System.out.println(s.lastIndexOf("53", 5));

		// 12. setCharAt(index, char) -- replace char at given index with given char
		s.setCharAt(0, 'Z');
		System.out.println(s);

		// 13. setLength(length) -- set string length -- deletes all char after given
		// length
		s.setLength(s.length() - 2);
		System.out.println(s);

		// 14. substring(start, [end]) -- from start till end of string for no end --
		// otherwise till end-1
		System.out.println(s.substring(0, 4));

		// 15. trimToSize() -- reduces capacity to size
		s.trimToSize();
		System.out.println(s.length());
		System.out.println(s.capacity());

		// StringBuffer -- thread safe -- multiple threads can use it without loss or
		// harm

		// StringBuilder -- faster(for single threaded programs also)

		// to tokenize a string -- StringTokenizer(str, String Delimiter)
		StringTokenizer st1 = new StringTokenizer("Hello Geeks How are you", " "); // it will cut out part of string
																					// when it will see " "
		// countTokens() -- returns no of total token
		int count = st1.countTokens();
		System.out.println("Total tokens are " + count);
		while (st1.hasMoreTokens()) // true if tokens are present in string tokenizer
			System.out.println(st1.nextToken()); // switch to every next token -- returns string not object

		// conversions
		// 1. String ---> Buffer
		str = "geeks";
		StringBuffer sbr = new StringBuffer(str);
		sbr.reverse(); // change in buffer won't occur change in String
		System.out.println(sbr);

		// String ---> Builder
		StringBuilder sbl = new StringBuilder(str);
		sbl.append("ForGeeks");
		System.out.println(sbl);

		// 2. Buffer ---> String
		str = sbr.toString();
		System.out.println(str);

		// Builder ---> String
		str = sbl.toString();
		System.out.println(str);

		// 3. Buffer ---> Builder -- possible only via String
		str = sbr.toString();
		sbl = new StringBuilder(str);
		System.out.println(sbl);
		System.out.println(sbr);

		// 4. int --> String
		int a = 45;
		// a. Integer.toString(int)
		str = Integer.toString(a);
		System.out.println(str);
		str = Integer.toString(50);
		System.out.println(str);

		// b. String.valueOf(int)
		str = String.valueOf(a);
		System.out.println(str);
		str = String.valueOf(50);
		System.out.println(str);

		// c. StringBuffer to StringBuilder
		// 1. create empty Buffer & Builder
		// 2. append given int
		// 3. convert Buffer/Builder --> String
		StringBuffer sbfr = new StringBuffer();
		sbfr.append(a);
		str = sbfr.toString();
		System.out.println(str);
		// same with Builder

		// d. Integer.toBinaryString(int) -- int to binary with string
		str = Integer.toBinaryString(a);
		System.out.println(str);

		// e. Integer.toOctalString(int) -- int to octal with string
		// f. Integer.toHexString(int) -- int to hexa with string
		// g. Integer.toString(int, any_base) -- int to given base with string
		str = Integer.toString(255, 7);
		System.out.println(str);

		// 5. String --> int
		// a. Integer.parseInt(str, [base]) -- for no base, base = 10, otherwise convert
		// str with given base
		a = Integer.parseInt("56");
		a = Integer.parseInt("-34");
		a = Integer.parseInt("56", 4); // conversion wrt base 4
		a = Integer.parseInt("geeks", 29); // valid bcoz base = 29, consist digits from 0 to 9 then chars a to s

		// b. Integer.valueOf(str, [base]) -- same as parseInt

	}
}
