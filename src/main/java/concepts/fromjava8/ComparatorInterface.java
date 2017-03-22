package concepts.fromjava8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import concepts.fromjava8.Person.Sex;

import static java.util.Comparator.*;



/**
 * Few different implementations of the Comparator to understand the influence of the new style.
 */
public class ComparatorInterface {

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(new Person("Tom",LocalDate.of(1950, 1, 20),Sex.MALE,"Tom@TEST.com"),
				new Person("John",LocalDate.of(1964, 10, 17),Sex.MALE,"JohnT@TEST.com"),
				new Person("Sara",LocalDate.of(1985, 7, 26),Sex.FEMALE,"Sara@TEST.com"),
				new Person("Greg",LocalDate.of(1983, 9, 07),Sex.MALE,"Greg@TEST.com"),
				new Person("Jane",LocalDate.of(2013, 5, 10),Sex.FEMALE,"Jane@TEST.com"));	
	 
		//Sorting with Comparator - sort people in the list in ascending order.
		
		//As we are sorting a List, obvious choice is the sort() method, the downsides of using this method is a "Void" method, which means
		//the list will be mutated when we call it.
		
		List<Person> ascendingAge = people.stream()
                                    .sorted((person1, person2) -> person1.compareByAge(person2))
                                    .collect(Collectors.toList());
		
		ascendingAge.stream().forEach(System.out::println);
		
		//Rather than writing .sorted((person1, person2) -> person1.compareByAge(person2)), we ask compiler to the routing for us using method reference
		ascendingAge = people.stream()
				              .sorted(Person::compareByAge)
				              .collect(Collectors.toList());
		
		//Reusing a comparator	
		Comparator<Person> compareAscending = (person1, person2) -> person1.compareByAge(person2);
		Comparator<Person> compareDescending = compareAscending.reversed();
		
		//Find Youngest & Oldest person in list - Min() & Max()
		people.stream()
			  .min(compareAscending)
			  .ifPresent(youngest -> System.out.println("Youngest: "+ youngest));
		
		people.stream()
		  	  .max(compareAscending)
		  	  .ifPresent(eldest -> System.out.println("Eldest: "+ eldest));	
		
		//Multiple & Fluent Comparisons - compare with ease based on multiple properties.
		people.stream()
		  .sorted((people1,people2)->people1.getName().compareTo(people2.getName()));
				
		// Using comparing method of Comparator
        final Function<Person,String> byName = person -> person.getName();
        people.stream()
        .sorted(comparing(byName));
        
        //Multiple Comparisons 
        final Function<Person,Long> byAge = person -> person.getAge();
        people.stream()
              .sorted((comparing(byName).thenComparing(byAge)));	
	}
}
