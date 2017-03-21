package concepts.fromjava8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *  Its reasonable to expect that picking one element from a collection would be simpler than picking multiple elements.
 */
public class PickingAnElement {

	
	public static void main(String[] args) {		
		final List<String> names = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		habitualApproach(names, "N");
		lambdaApproach(names, "Z");
	}
	
	private static void habitualApproach(final List<String> names, final String startingLetter) {
		String foundName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		if(null == foundName){
			System.out.println("No name found");
		}else{
			System.out.println("NameFound:" +foundName);
		}
	}
	
	private static void lambdaApproach(final List<String> names, final String startingLetter) {
		Optional<String> foundName = names.stream()
		.filter(name -> name.startsWith(startingLetter))
		.findFirst();
		System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
	}
	
}
