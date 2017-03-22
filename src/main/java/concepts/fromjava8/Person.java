package concepts.fromjava8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pkumar95
 *
 */
public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	private String name;
	
	private LocalDate birthday;
	
	private Sex gender;
	
	private String emailAddress;

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public Long getAge(){
		return ChronoUnit.YEARS.between(birthday, LocalDate.now());
	}

	public void printPerson() {
		System.out.println("Person: "+ toString());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress="
				+ emailAddress + "]";
	}

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	
	public int compareByAge(Person b) {
		return this.birthday.compareTo(b.birthday);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
