package concepts.fromjava8.streams;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


//https://stackoverflow.com/questions/54489983/java-8-multilevel-grouping-and-reducing
public class MultiLevelGrouping {
	
	public static void main(String[] args) {
		List<Employee> employees  = new ArrayList<>();
		employees.add(new Employee("E1", "A1", "D1"));
		employees.add(new Employee("E2", "A1", "D1"));
		employees.add(new Employee("E3", "A1", "D2"));
		employees.add(new Employee("E1", "A2", "D1"));
		employees.add(new Employee("E1", "A3", "D1"));
		employees.add(new Employee("E3", "A2", "D2"));
		
	}

	@AllArgsConstructor
	@Data
	static class Employee {
		private final String name;

		private final String account;
		
		private final String dept;
	}

	@AllArgsConstructor
	@Data
	static class EmployeeInfo {

		private final String name;

		private final List<String> accounts;
	}
}
