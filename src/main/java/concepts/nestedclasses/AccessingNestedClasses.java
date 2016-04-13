package concepts.nestedclasses;

public class AccessingNestedClasses {

	public static void main(String[] args) {
		/** An instance of InnerClass can exist only within an instance of
		 OuterClass and has direct access to the methods and fields of its
		 enclosing instance.
		 To instantiate an inner class, you must first instantiate the outer
		 class. */
		NestedClasses nestedClasses = new NestedClasses();
		
		NestedClasses.InnerClass innerClass = nestedClasses.new InnerClass();
		
		innerClass.accessMembers(1);
		
		nestedClasses=null;
		
		innerClass.accessMembers(2);
		
		System.out.println(innerClass.getSize());

	}

}
