package concepts.fromjava8;

import java.util.List;
import java.util.function.Predicate;

import concepts.fromjava8.LambdaExpressions.CheckPerson;


/**
 * How do you determine the type of a lambda expression..? 
 */
public class TargetTyping {

	// When the Java runtime invokes the method printPersons, it's expecting a data type of CheckPerson, so the lambda expression is of this type
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	//When the Java runtime invokes the method printPersonsWithPredicate, it's expecting a data type of Predicate<Person>	
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

}