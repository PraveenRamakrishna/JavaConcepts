package concepts.collection.map;

public class Department {
	private String depatmentName;
	
	private String departmentId;
	
	
	
	public Department(String depatmentName, String departmentId) {
		super();
		this.depatmentName = depatmentName;
		this.departmentId = departmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepatmentName() {
		return depatmentName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depatmentName == null) ? 0 : depatmentName.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (depatmentName == null) {
			if (other.depatmentName != null)
				return false;
		} else if (!depatmentName.equals(other.depatmentName))
			return false;
		return true;
	}*/

	public void setDepatmentName(String depatmentName) {
		this.depatmentName = depatmentName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (depatmentName == null) {
			if (other.depatmentName != null)
				return false;
		} else if (!depatmentName.equals(other.depatmentName))
			return false;
		return true;
	}

	
	
}
