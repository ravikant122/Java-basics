package all_java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class SStream {

	
	public static void main(String[] args) throws IOException {
		
		// stream pipeline = source -> intermediate operations -> terminal
		
		// streams can be created from Collections, ints, longs, doubles, arrays, lines of file
		// intermediate operations can be filter, map, sort etc. -- all these return a stream 
		// terminal may be forEach, collect, reduce etc. -- all these return either void or non-stream result
		
		// 1. Integer Stream
		IntStream	
			.range(1,10)  // source
			.forEach(System.out::print);  // terminal 
		System.out.println();	// just new line
		
		// 2. skip
		IntStream
			.range(1, 10) // source
			.skip(5)	// intermediate -- skip upto 5
			.forEach(x -> System.out.print(x)); // terminal
		System.out.println();
		
		// 3. sum of Ints
		System.out.println(
			IntStream
				.range(1, 10)
				.sum());
		System.out.println();
		
		// 4. Stream.of, sorted, findFirst
		Stream.of("Ava","Albert","Amen")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		
		// 5. Array Stream, filter, sort
		String[] names = {"sfsfsfsmjsfkjnskjfn","srgthh","sdghryhrhtjknjnjknkjn","teryy","hjghjg","aewacs","bnvmnb"};
		Arrays.stream(names) 	// same as Stream.of(names)
			.filter(x->x.startsWith("s"))
			.sorted()
			.forEach(System.out::println);
		
		// 6. average of ints
		Arrays.stream(new int[] {1,2,3,4,5})
			.map(x -> x*x)
			.average()
			.ifPresent(System.out::println);
		
		// 7. list stream, map, filter
		List<String> people = Arrays.asList(names);
		people.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("s"))
			.forEach(System.out::println);
		
		// 8. Stream rows from text files, sort, filter
		Arrays.stream(names) 
			.sorted()
			.filter(x -> x.length()>10)
			.forEach(System.out::println);
		
		// 8. Stream rows from text files, sort, filter
		List<String> list = Arrays.stream(names) 
			.sorted()
			.filter(x -> x.contains("s"))
			.collect(Collectors.toList());
		System.out.println(list);
		
		// 9. map, split, filter
		int count = (int)Arrays.stream(names)
						.map(x -> x.split("")) // already seprated by , so no splitting this time 
						.filter(x -> x.length == 6)
						.count();
		System.out.println(count);
		
		// 10. storing into map
		Map<Object, Object> map = new HashMap<>();
		map = Arrays.stream(names)
				.map(x -> x.split(""))
				.filter(x -> x.length == 6)
				.collect(Collectors.toMap(x->x, x -> x.length));
		for(Object key : map.keySet())
			System.out.println(map.get(key)); 	// value of keys
		
		// 11. reduce
		 List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8); 
		 int sum = array.stream()
				 .reduce(0,(element1, element2) -> element1 + element2);  
		 // 0 = staring element
		 // element1 = running sum
		 // element2 = new element
		 System.out.println("The sum of all elements is " + sum);
		
	}

}
