package session8assignments; //Package declaration

import java.io.*; //To import necessary classes from java.io package
import java.util.Scanner; //To import scanner class from java.util package

/**
 * This class performs File Copy using File Handling functions.
 *
 */
public class FileCopy 
{
	public static void main(String args[])// This is the main method.
	{
		String sourceFileName,
				destinationFileName; /* Declaration of string variables to store source and destination file names */
		Scanner scan = new Scanner(System.in); // Creating Scanner object to read the inputs

		System.out.print("Enter Source File Name with extension .txt : "); /*
																						 * Prompts the user to enter
																						 * source file name
																						 */
		sourceFileName = scan.nextLine(); // scans the source file name
		System.out.print("Enter Destination File Name with extension .txt) : ");
		/* Prompts the user to enter destination file name */
		destinationFileName = scan.nextLine(); // scans the destination file name
		scan.close(); // Scanner object closed
		InputStream inStream = null; // Initialization of InputStream class to read data from source file
		OutputStream outStream = null; // Initialization of InputStream class to read data from destination file

		try // try block in case exception occurs
		{
			File file1 = new File(sourceFileName); // Object of File class to store pathname of source file
			File file2 = new File(destinationFileName); // Object of File class to store pathname of destination file

			inStream = new FileInputStream(file1); /*
													 * Data from source file file1 to be read in the form of bytes using
													 * FileInputStream and stored in inStream
													 */
			outStream = new FileOutputStream(file2); /*
														 * Data to be written to destination file file2 in the form of
														 * bytes using FileOutputputStream and stored in inStream
														 */

			byte[] buffer = new byte[1024]; // Declaration and initialization of byte array

			int length; // declaration of length variable
			while ((length = inStream.read(buffer)) > 0) // while loop to read the file till the end
			{
				outStream.write(buffer, 0, length); // write into file2 until the end of file1
			} // while loop closed

			inStream.close(); // InputStream class closed
			outStream.close(); // OutputStream class closed

			System.out.println("File Copied.."); // Informs the user the file is copied
		} // try block closed
		catch (IOException e) // catch block to catch input/output exception
		{
			e.printStackTrace(); // Prints information about exception(line numbers + call stack)
		} // catch block closed
	}// main method closed
}// Class closed