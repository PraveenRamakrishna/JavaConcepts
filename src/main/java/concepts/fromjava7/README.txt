Java Programming Language Enhancements in Java SE 7:

- Binary Literals: In Java SE 7, the integral types (byte, short, int, and long) can also be expressed using the binary number system. 
				   To specify a binary literal, add the prefix 0b or 0B to the number.


- Underscores in Numeric Literals: Any number of underscore characters (_) can appear anywhere between digits in a numerical literal. 
								   This feature enables you, for example, to separate groups of digits in numeric literals, 
								   which can improve the readability of your code.

								   
- Strings in switch Statements: You can use the String class in the expression of a switch statement.


- Type Inference for Generic Instance Creation: You can replace the type arguments required to invoke the constructor of a generic class 
												with an empty set of type parameters (<>) as long as the compiler can infer the type 
												arguments from the context. This pair of angle brackets is informally called the diamond.


- The try-with-resources Statement: The try-with-resources statement is a try statement that declares one or more resources. 
									A resource is an object that must be closed after the program is finished with it. 
									The try-with-resources statement ensures that each resource is closed at the end of the statement. 
									Any object that implements the new "java.lang.AutoCloseable" interface or the "java.io.Closeable" interface can be used as a resource. 
									The classes java.io.InputStream, OutputStream, Reader, Writer, java.sql.Connection, Statement, 
									and ResultSet have been retrofitted to implement the AutoCloseable interface and can all be used as resources in a try-with-resources statement.


- Catching Multiple Exception Types and Rethrowing Exceptions with Improved Type Checking - A single catch block can handle more than one type of exception. 
									In addition, the compiler performs more precise analysis of rethrown exceptions than earlier releases of Java SE. 
									This enables you to specify more specific exception types in the throws clause of a method declaration.


- Improved Compiler Warnings and Errors When Using Non-Reifiable Formal Parameters with Varargs Methods: The Java SE 7 complier generates 
			a warning at the declaration site of a varargs method or constructor with a non-reifiable varargs formal parameter. 
			Java SE 7 introduces the compiler option -Xlint:varargs and the annotations @SafeVarargs and 
			@SuppressWarnings({"unchecked", "varargs"}) to supress these warnings.