package concepts.fromjava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


/**
 * Java code to manipulate collections will never be the same
 */
public class UsingCollections {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Manu", "Mohan", "Arun", "Pacha", "Ashok", "Sharu");

		// Habitual way of printing a list - used more often when we need to work with Index
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}

		// More advanced - use of Iterator - next() & hasNext()
		for (String friend : friends) {
			System.out.println(friend);
		}

		// Reasons to go for functional style - for loops are inherently sequential, The code fails at "Tell, don't ask" principle.

		// JDK 8 - Enhanced forEach - passed an anonymous instance of Consumer, the forEach() method will invoke accept() method of given consumer
		friends.forEach(new Consumer<String>() {
			@Override
			public void accept(final String name) {
				System.out.println(name);
			}
		});
		
		// The bad thing about above code is its lot more verbose. Thankfully we can fix that quickly - using Lambda Expression.		
		friends.forEach((final String name) -> System.out.println(name));
		
		//NOTE:forEach() has a limitation, once the method starts, we can't break out of the iteration
		//(why..? due to design issue when streams are run in parallel)
		
		//TRANSFORMING LIST
		
		//REQUIREMNT - convert a list of names to all capital letters
		
		//Using Collection Stream & Map method and Lambda Expression
		friends.stream()
		.map(name -> name.toUpperCase())
		.forEach(name -> System.out.println(name));
		
		//REQUIREMNT - Finding elements - Lets pick the names starting with letter A
		List<String> startsWithA = 
		friends.stream()
			.filter(name -> name.startsWith("A"))
			.map(name -> name.toUpperCase())
			.collect(Collectors.toList());
	}
}
