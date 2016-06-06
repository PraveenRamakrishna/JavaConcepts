package concepts.fromjava8;

import java.util.List;
import java.util.function.Predicate;

/**
 * Lambda Expressions: In Java, lambda expression is SAM type, which is an
 * interface with a single abstract method / functional interface.
 * 
 * The runtime representation of a lambda is a functional interface (or a
 * SAMtype), an interface that defines only one abstract method.
 */
public class LambdaExpressions {

	interface CheckPerson<T> {
		boolean test(T t);
	}

	// Approach 1: Create Methods that Search for Persons that Match One Characteristic
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
	
	// Approach 2: Create More Generalized Search Methods
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// Approach 3: Specify Search Criteria Code in a Local Class 
	// Approach 4: Specify Search Criteria Code in an Anonymous Class 
	// Approach 5: Specify Search Criteria Code with a Lambda Expression
	public static void printPersons(List<Person> roster, CheckPerson<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	// Approach 6: Specify Search Criteria Code with a Lambda Expression - Predicate
		public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
			for (Person p : roster) {
				if (tester.test(p)) {
					p.printPerson();
				}
			}
		}
	
	public static void main(String... args) {
		List<Person> roster = Person.createRoster();

		System.out.println("Rosters: ");
		for (Person person : roster) {
			System.out.println(person);
		}
		
		 // Approach 1: Create Methods that Search for Persons that Match One Characteristic
		System.out.println("Rosters above certain {50} age: ");
		printPersonsOlderThan(roster, 50);
		
		 // Approach 2: Create More Generalized Search Methods
		System.out.println("Rosters b/w age group - {5} & {40}");
		printPersonsWithinAgeRange(roster, 5, 40);
		
		// Approach 4: Specify Search Criteria Code in an Anonymous Class
		System.out.println("Rosters for a given Criteria - Anonymous Class: ");
		printPersons(roster, new CheckPerson<Person>() {
			@Override
			public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 35
                    && p.getAge() <= 70;
            }});
		
		// Approach 5: Specify Search Criteria Code with a Lambda Expression
		
		// NOTE: Basically, what we care about when transforming the old-style Java syntax to
		// the lambda syntax is the set of the parameter of the interface method, and the functional part itself.
		System.out.println("Rosters for a given Criteria - lambda expression: ");
		CheckPerson<Person> checkPerson = (Person p) -> {
			return p.getGender() == Person.Sex.MALE //Seems like the one-liner lambda expressions have implicit return for the statement.
					&& p.getAge() >= 35 
					&& p.getAge() <= 70;};
		printPersons(roster, checkPerson);
		
		// Approach 6: Specify Search Criteria Code with a Lambda Expression & Predicate
		System.out.println("Rosters for a given Criteria - lambda expression with Predicate: ");
		
		// Lambda parameter type declaration: You either declare the types of all the parameters for the lambda, or omit all of them
		printPersonsWithPredicate(roster,  p -> p.getGender() == Person.Sex.MALE
		                    && p.getAge() >= 35
		                    && p.getAge() <= 70 );
	}
}