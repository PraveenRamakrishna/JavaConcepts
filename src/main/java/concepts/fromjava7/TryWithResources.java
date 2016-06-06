package concepts.fromjava7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * Try-with-resource for the Classes That Implement the AutoCloseable or Closeable Interface
 */
public class TryWithResources {

	// use of finally block to ensure that a resource is closed regardless of
	// whether the try statement completes normally or abruptly
	public String pirorToJava7(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	// The try-with-resources statement is a try statement that declares one or
	// more resources. A resource is as an object that must be closed after the
	// program is finished with it. The try-with-resources statement ensures
	// that each resource is closed at the end of the statement. Any object that
	// implements java.lang.AutoCloseable, which includes all objects which
	// implement java.io.Closeable, can be used as a resource.
	public String inJava7(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
	
	//declare one or more resources in a try-with-resources statement
	public static void writeToFileZipFileContents(String zipFileName, String outputFileName)throws java.io.IOException {
		/**
		 * Suppressed Exceptions: An exception can be thrown from the block of
		 * code associated with the try-with-resources statement. In the example
		 * writeToFileZipFileContents, an exception can be thrown from the try
		 * block, and up to two exceptions can be thrown from the
		 * try-with-resources statement when it tries to close the ZipFile and
		 * BufferedWriter objects. If an exception is thrown from the try block
		 * and one or more exceptions are thrown from the try-with-resources
		 * statement, then those exceptions thrown from the try-with-resources
		 * statement are suppressed, and the exception thrown by the block is
		 * the one that is thrown by the writeToFileZipFileContents method. You
		 * can retrieve these suppressed exceptions by calling the
		 * Throwable.getSuppressed method from the exception thrown by the try
		 * block.
		 */
		java.nio.charset.Charset charset = java.nio.charset.Charset.forName("US-ASCII");
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with try-with-resources statement.
		// try-with-resources statement contains two declarations that are separated by a semicolon.
		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
			 java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {

			for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {

				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}
}
