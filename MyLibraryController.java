
/*
 * This is where the rating and adding can be made.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyLibraryController{
	
	private boolean satisfied = false;
	private MyLibraryModel model;
	private Book book;
	private Scanner input;
	
	public boolean isSatisfied() {
	      return this.satisfied;
	}
	
	public void setSatisfaction() {
		this.satisfied = true;
	}
	
	public void makeRead(boolean read) {
		book.read = read;
	}
	
	/*
	 * This is similar to addBook, but this time we are taking a whole text file
	 * then merging both of the lists of books so that the books are added.
	 */
	public void addBooks() {
		try {
			System.out.println("Type the text file you would like to add: ");
			input = new Scanner(System.in);
			String search = input + "";
	        File file = new File(search);
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
	
	
	
	
	
	
	
	
	
