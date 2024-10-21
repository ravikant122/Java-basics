package all_java.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
	private int id;
	private int rank;
	private String name;
	public Employee(int id, int rank, String name) {
		super();
		this.id = id;
		this.rank = rank;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Employee o) {
		return this.getRank() - o.getRank(); // can be less than, equal to, or greater than zero
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", rank=" + rank + ", name=" + name + "]";
	}
}

class NameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

public class Compare {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, 2, "c");
		Employee e2 = new Employee(2, 3, "a");
		Employee e3 = new Employee(3, 1, "b");
		
		List<Employee> employees = Arrays.asList(e1, e2, e3);
		System.out.println("before sorting using comparable");
		employees.forEach(employee -> System.out.println(employee.toString()));
		
		Collections.sort(employees);
		
		System.out.println("after sorting using comparable");
		employees.forEach(employee -> System.out.println(employee.toString()));
		
		System.out.println("after sorting using name comparator");
		Collections.sort(employees, new NameComparator());
		employees.forEach(employee -> System.out.println(employee.toString()));
		
		Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
		Collections.sort(employees, idComparator);
		System.out.println("after sorting using id Comparator lambda");
		employees.forEach(employee -> System.out.println(employee.toString()));
		
		
		/*
		 	Comparable is like natural order of elements, we can only define the order one time as
		 	we can only override the compareTo only once
		 	
		 	Comparator is like external sorting, we can sort in different ways
		 	we override the compare method in this
		 */
	}
}
