package concepts.fromjava8;

import static java.util.stream.Collectors.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

import concepts.fromjava8.Person.Sex;

public class Aggregration {

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(new Person("Tom",LocalDate.of(1950, 1, 20),Sex.MALE,"Tom@TEST.com"),
				new Person("John",LocalDate.of(1964, 10, 17),Sex.MALE,"JohnT@TEST.com"),
				new Person("Sara",LocalDate.of(1985, 7, 26),Sex.FEMALE,"Sara@TEST.com"),
				new Person("Greg",LocalDate.of(1983, 9, 07),Sex.MALE,"Greg@TEST.com"),
				new Person("Jane",LocalDate.of(2013, 5, 10),Sex.FEMALE,"Jane@TEST.com"));	
		
		//Lets group people by age
		Map<Long, List<Person>> byAge =	
		people.stream()
		       .collect(groupingBy(Person::getAge));
	    System.out.println("People Grouped by age: " + byAge);
	    
		//Continuing with previous example, instead of creating a map of all person object, lets get only people name
	    Map<Long, List<String>> nameOfPeopleByAge = 
	    people.stream()
	    	  .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
	    System.out.println("People Grouped by age:" + nameOfPeopleByAge);		
	    
	    //One more combination: Lets group the names by their first character & then get the oldest person in each group.
	    Map<Character,Optional<Person>> oldestPersonOfStartingLetter =
	    people.stream()
	          .collect(groupingBy(person ->person.getName().charAt(0),reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
	    System.out.println("Oldest person in starting letter: " + oldestPersonOfStartingLetter);
	    
	}

}
