package concepts.collection;

public final class PriorityTask implements Comparable<PriorityTask> {
	private final Task task;
	private final Priority priority;
	
	public PriorityTask(Task task, Priority priority){
		this.task = task;
		this.priority = priority;
	}

	public Task getTask() {
		return task;
	}

	public Priority getPriority() {
		return priority;
	}

	public int compareTo(PriorityTask priorityTask) {
		return this.priority.compareTo(priorityTask.getPriority());
		//return i!=0?i:this.task.compareTo(priorityTask.getTask());
	}

	@Override
	public String toString() {
		return task + " : " + priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
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
		PriorityTask other = (PriorityTask) obj;
		if (priority != other.priority)
			return false;
		return true;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		PriorityTask other = (PriorityTask) obj;
		if (priority != other.priority)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}*/
 }
