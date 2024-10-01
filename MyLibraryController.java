
/*
 * This is where the rating and adding can be made.
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyLibraryController{
	
	private boolean satisfied = false;
	private MyLibraryModel model;
	private Book book;
	
	public boolean isSatisfied() {
	      return this.satisfied;
	}
	
	public void setSatisfaction() {
		this.satisfied = true;
	}
	
	public void setRead(boolean read) {
		book.read = read;
	}
	
	/*
	 * This is similar to addBook, but this time we are taking a whole text file
	 * then merging both of the lists of books so that the books are added.
	 */
	public void addBooks(String fileName) {
		try {
	        File file = new File(fileName);
	        Scanner scanner = new Scanner(file);
	        scanner.nextLine(); // skip template line
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            model.addFromFile(line);
	        }

	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + e.getMessage());
	    }
	}
		
	







}
	
	
	
	
	
	
	
	
	
