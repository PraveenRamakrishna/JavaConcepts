package concepts.fromjava7;

import java.io.IOException;
import java.sql.SQLException;

//Handling More Than One Type of Exception
public class CatchingMultipleExceptionTypes {

	public void handleMoreThanOneExceptionPriorToJava7() {
		try {
			boolean flag = true;
			if (flag) {
				throw new IOException();
			} else {
				throw new SQLException();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	//The catch clause specifies the types of exceptions that the block can handle, and each exception type is separated with a vertical bar (|).
	public void handleMoreThanOneExceptionInJava7() {
		try {
			boolean flag = true;
			if (flag) {
				throw new IOException();
			} else {
				throw new SQLException();
			}
		} catch (IOException | SQLException e) { 
			//Note: If a catch block handles more than one exception type, then the catch parameter is implicitly final.
			throw new RuntimeException();
		}
	}
}
