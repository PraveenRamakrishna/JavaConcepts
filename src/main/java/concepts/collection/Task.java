package concepts.collection;

public abstract class Task implements Comparable<Task>{
	
	protected Task(){}
	
	@Override
	public boolean equals(Object object){
		return toString().equals(object.toString());
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	public int compareTo(Task task){
		return   toString().compareTo(task.toString());
	}
	
	public abstract String toString();
}
