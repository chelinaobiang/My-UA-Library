
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
	
	/*
	 * This is similar to addBook, but this time we are taking a whole text file
	 * then merging both of the lists of books so that the books are added.
	 */
	public void addBooks(String fileName) {
		System.out.println("Type the text file you would like to add: ");
		input = new Scanner(System.in);
		String search = input + "";
		try {
			File file = new File(search);
	        Scanner scanner = new Scanner(file);
	        if (scanner.hasNextLine()) {
	        	scanner.nextLine(); // skips first line with headers
	        }
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] info = line.split(";");
	            if (info.length == 2) {
	            	String title = info[0].trim();
	            	String author = details[1].trim();
	            	model.addBook(title, author); 
	            } 
	            model.addFromFile(line);
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + e.getMessage());
	    }
		scanner.close();
	}
		
	







}
	
	
	
	
	
	
	
	
	
		

}
