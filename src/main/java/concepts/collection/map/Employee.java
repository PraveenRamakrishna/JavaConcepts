package concepts.collection.map;

public class Employee {
	private String name;
	private int employeeId;
	
	public Employee() {
		super();
	}

	public Employee(String name, int employeeId) {
		super();
		this.name = name;
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeId=" + employeeId + "]";
	}
	
	
}
