package concepts.fromjava8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Use elegant functional-style facility to iterate through the list, rather than an long-winded traditional external iterator.
 */
public class WorkingWithFilesInDirectory {

	public static void main(String[] args) throws IOException {

		System.out.println("List the names of all the files in Directory:");
		Files.list(Paths.get("."))
			 .forEach(System.out::println);
		
		System.out.println("List only sub-directories in the directory"); 
		Files.list(Paths.get("."))
		     .filter(Files::isDirectory)
		     .forEach(System.out::println);
		
		System.out.println("Cherry-pick filesnames in a directory - using newDirectoryStream()");
		Files.newDirectoryStream(Paths.get("."), path -> path.toString().endsWith(".git"))
		     .forEach(System.out::println);
	}

}
