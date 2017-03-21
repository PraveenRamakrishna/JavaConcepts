package concepts.fromjava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Conciseness we've can by using lambda expression is nice, but code duplication may sneak in quickly.
 */
public class ReusingLambdaExpressions {

	public static void main(String[] args) {
		//Requirement - Lets pick names starting with N
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		long countFriendsStartN = friends.stream().filter(friend -> friend.startsWith("N")).count();
		long countEditorsStartN = editors.stream().filter(editor -> editor.startsWith("N")).count();
		long countComradesStartN = editors.stream().filter(comrade -> comrade.startsWith("N")).count();
		//Lambda Expression, made code concise, but quietly led to duplicate code.
		
		//Lets re-factor above code to make it DRY - Don't Repeat Yourself 
		
		final Predicate<String> startWithN = name -> name.startsWith("N");
		
		//Rather than duplicating the Lambda Expression several times, we created it once & stored in a reference of type Predicate.
		
		countFriendsStartN = friends.stream().filter(startWithN).count();
		countEditorsStartN = editors.stream().filter(startWithN).count();
		countComradesStartN = editors.stream().filter(startWithN).count();
		
		//Duplication in Lambda Expressions
		
		//Requirement - Lets pick names starting with N & B
		
		final Predicate<String> startWithB = name -> name.startsWith("B");
		
		countFriendsStartN = friends.stream().filter(startWithN).count();
		long countFriendsStartB = friends.stream().filter(startWithB).count();
		
		//Removing Duplication with Lexical Scoping
		
		countFriendsStartN = friends.stream().filter(checkIfStartWith("N")).count();
		countFriendsStartB = friends.stream().filter(checkIfStartWith("B")).count();
		
		//Re-factoring to narrow the scope - instead of using a static method to cache each variable 
		
		final Function<String, Predicate<String>> startWithLetter = letter -> name -> name.startsWith(letter);
		
		countFriendsStartN = friends.stream().filter(startWithLetter.apply("N")).count();
		countFriendsStartB = friends.stream().filter(startWithLetter.apply("B")).count();		
	}
	
	// Lexical scoping - from within a lambda expression we can only access local variables that are final or effectively final
	public static Predicate<String> checkIfStartWith(final String letter){
		return name -> name.startsWith(letter);
	}
}
