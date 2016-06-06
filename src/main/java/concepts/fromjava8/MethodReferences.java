package concepts.fromjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * You use lambda expressions to create anonymous methods. Sometimes, however, a
 * lambda expression does nothing but call an existing method. In those cases,
 * it's often clearer to refer to the existing method by name. Method references
 * enable you to do this; they are compact, easy-to-read lambda expressions for
 * methods that already have a name
 */

public class MethodReferences {

	class PersonAgeComparator implements Comparator<Person> {
		public int compare(Person a, Person b) {
			return a.getBirthday().compareTo(b.getBirthday());
		}
	}
	
	class ComparisonProvider {
		public int compareByName(Person a, Person b) {
			return a.getName().compareTo(b.getName());
		}

		public int compareByAge(Person a, Person b) {
			return a.getBirthday().compareTo(b.getBirthday());
		}
	}

	public static void main(String... args) {
		//Use of Comparator implementation
		Arrays.sort((Person[]) new ArrayList<Person>().toArray(), new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getBirthday().compareTo(o2.getBirthday());
			}
		});

		//Use of lambda expression instead of defining and then creating a new instance of a class that implements Comparator
		Arrays.sort((Person[]) new ArrayList<Person>().toArray(), (Person a, Person b) -> {
			return a.getBirthday().compareTo(b.getBirthday());
		});
		
		//Invoking method instead in the body of the lambda expression:
		Arrays.sort((Person[]) new ArrayList<Person>().toArray(),(a, b) -> Person.compareByAge(a, b));
		
		//Kinds of Method References - Reference to a Static Method
		Arrays.sort((Person[]) new ArrayList<Person>().toArray(), Person::compareByAge);
		
		//Kinds of Method References - Reference to an instance method of a particular object
		Arrays.sort((Person[]) new ArrayList<Person>().toArray(), new MethodReferences().new ComparisonProvider()::compareByName);
		
		String[] stringArray = { "Barbara", "James", "Mary", "John",  "Patricia", "Robert", "Michael", "Linda" };
		
		Arrays.sort(stringArray, String::compareToIgnoreCase);
	}
}
