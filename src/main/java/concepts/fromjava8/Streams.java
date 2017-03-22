package concepts.fromjava8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import concepts.fromjava8.Person.Sex;

/**
 * The new java.util.stream package has been added to JDK which allows us to perform "filter/map/reduce" like operations with the collections in Java8
 * 
 * A stream is something like an iterator. However, a stream can only be traversed once, then it’s used up. Streams may also be infinite, which
 * basically means that streams are “lazy” - we never know in advance, how many elements we will have to process.
 * 
 * One important thing to notice about Stream API is that the source data is not mutated during the operations. 
 * This is due to the fact that the source of the data might not exist as such, or the initial data might be required somewhere else in the application code.
 * 
 * The Stream API would allow us to declare either sequential or parallel operations over the stream of data
 *
 */
public class Streams {
	
	/**
	 * Stream operations are divided into intermediate and terminal operations,
	 * and are combined to form stream pipelines. A stream pipeline consists of
	 * a source (such as a Collection, an array, a generator function, or an I/O
	 * channel); followed by zero or more intermediate operations such as
	 * Stream.filter or Stream.map; and a terminal operation such as
	 * Stream.forEach or Stream.reduce.
	 */

	public static void  main (String... args){
	
	//Intermediate operations, are used to described the transformations that should be performed over the stream of data
	List<Person> persons = null;

	System.out.println("filter - excludes all elements that don’t match a Predicate");
	persons.stream().filter(p -> p.getAge() > 18).forEach(System.out::println);; 
	
	//Intermediate operations are further divided into stateless and stateful operations.
		
	// Stateless operations, such as filter and map, retain no state from
	// previously seen element when processing a new element -- each element
	// can be processed independently of operations on other elements
	System.out.println("\nmap - perform transformation of elements using a Function");
	persons.stream().filter(p -> p.getAge() < 18).map(person-> new Student(person)).forEach(System.out::println);
	
	System.out.println("\npeek - perform some action on each element as it is encountered");
	persons.stream().filter(p -> p.getAge() < 18).peek(System.out::println).map(person-> new Student(person)).forEach(System.out::println);	

	// Stateful operations, such as distinct and sorted, may incorporate
	// state from previously seen elements when processing new elements.
	System.out.println("\ndistinct - excludes all duplicate elements according to their equals(..) behavior");
	persons.add(new Person("Test",LocalDate.of(1950, 1, 20),Sex.MALE,"TEST@TEST.com"));
	persons.stream().filter(p -> p.getAge() > 60).distinct().forEach(System.out::println);	
	
	System.out.println("\nsorted - ensures that stream elements in subsequent operations are encountered according to the order imposed by a Comparator.");
	persons.stream().distinct().sorted((o1,o2) -> o2.getAge().compareTo(o1.getAge())).forEach(System.out::println);
	
	System.out.println("\nlimit - ensures that subsequent operations only see up to a maximum number of elements.");
	persons.stream().limit(2).forEach(System.out::println);
	
	//TODO - substream - ensure that subsequent operations only see a range (by	index) of elements.
	
	//TODO - flatMap - transforms each element into zero or more elements by way of another Stream.

	/**Terminating operations - A terminal operation must be the final operation invoked on a stream.
	Once a terminal operation is invoked, the stream is “consumed” and is no longer usable*/	
		
	//Aggregate Operations - return one value by combining the contents of a stream
	System.out.print("\nAverage - Returns an OptionalDouble describing the arithmetic mean of elements of this stream: ");
	persons.stream().distinct().mapToLong(p -> p.getAge()).average().ifPresent(System.out::println);;
	
	System.out.print("\nSum of elements in the stream: ");
	System.out.println(persons.stream().distinct().mapToLong(p -> p.getAge()).sum());
	
	System.out.print("\nCount of elements in the stream: ");
	System.out.println(persons.stream().distinct().mapToLong(p -> p.getAge()).count());
	
	System.out.print("\nMin of elements in the stream: ");
	persons.stream().distinct().min((o1,o2)->o1.getAge().compareTo(o2.getAge())).ifPresent(System.out::println);
	
	System.out.print("\nMax of elements in the stream: ");
	persons.stream().distinct().max((o1,o2)->o1.getAge().compareTo(o2.getAge())).ifPresent(System.out::println);
	
	//Reduction operations - reduction operations that return a collection instead of a single value
	System.out.print("\nCollect - acquire the final results we have to collect:s ");
	List<Student> students = persons.stream().filter(p -> (p.getAge() < 18)).map(Student::new).collect(Collectors.toCollection(ArrayList::new));
	students.stream().forEach(System.out::println);
	
	//Parallel & sequential
	System.out.print("\ns Possible to start consuming the data concurrently, then switch to sequential processing and back at any point in the flow: ");
	persons.stream().parallel().filter(p -> (p.getAge() < 18)).map(Student::new).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
	}
}

class Student {
	Person person;

	Student(Person p) {
		this.person = p;
	}

	@Override
	public String toString() {
		return "Student [person=" + person + "]";
	}
}
