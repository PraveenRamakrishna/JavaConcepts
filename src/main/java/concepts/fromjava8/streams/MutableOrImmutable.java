package concepts.fromjava8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MutableOrImmutable {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Kid"));
		List<Person> immutable  = people.stream()
										.map(e-> new Kid(e.getColor()))
													 .collect(Collectors.toList());
		immutable.add(new Kid("White"));
		System.out.println(people);

	}
	
	@AllArgsConstructor
	@Data
	static class Person{
		private String color;
	}
	

	static class Kid extends Person{
		public Kid(String color) {
			super(color);
		}
	}
}
