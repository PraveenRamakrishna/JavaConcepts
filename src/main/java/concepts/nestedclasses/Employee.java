package concepts.nestedclasses;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	
	private int employeeNumber ;
	
	
	private String employeeName;
	
	public int compare(Employee o1, Employee o2) {
		if(o1.getEmployeeNumber()>o2.getEmployeeNumber()){
			return -1;
		}else{
			return 0;
		}
	}
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


}
