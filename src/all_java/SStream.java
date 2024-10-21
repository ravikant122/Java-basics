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
		// stream is lazy means it won't produce any result if it doesn't have any terminal operation
		
		/*
			how stream works internally
			
			if we use .filter().map().peek() (peek to see stream in between operations)
			then its not like all elements first go through filter first then map then peek
			elements goes into all these operation one by one means first elements will go through
			filter then map then peek then 2nd will come
			
			there are two types of operations
			1. stateless - no need to know about other elements - like filter, map
			2. stateful - need to know about all elements - like sorted
			
			so if we use .filter().sorted().map() - then first all elements go through filter
			then sorted then map
			instead we should write like, filter.map.sorted - now elements go through filter then map
			then all elements in sorted
			
			
			parallel stream - first it will divide the given collection into chunks and then process
			each chunk using different threads then it combines the result of all the chunks
			it always divide bigger chunks into half(low, mid, half) - trySplit is the method it calls
			
			
			type of operations
			1. convert to stream - Arrays.stream(arr), someCollections.stream(), Stream.of(...elements)
				StreamBuilder.add(element).add(element)
			
			2. internal operations - filter, map, peek, flatMap, sorted, distinct, skip
			3. terminal operations - collect, forEach, reduce, sum, max, min, average, count, findFirst,
				findAny, anyMatch, allMatch, noneMatch
		 */
		
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
