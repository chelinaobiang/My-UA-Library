/* Genesis Benedith & Chelina Obiang
 * This file contains a main method that runs a text-based 
 * user interface where the user can enter commands to get 
 * or add information to the library
 */
import java.io.BufferedReader;
import java.util.Scanner;
public class MyLibrary{
	private Scanner scanner;
	private Boolean read;
	public MyLibrary(){
		
		
	}
	
	/*
	 * The user will search for a book based on book title, author, or rating.
	 * We can make this interactive to where there can be questions asked about what you
	 * will want to search for instead of confusing an invalid input.
	 */
	public String Search() {
		return null;
		
	}
	
	/*
	 * This is where the user will add a book to the library list
	 * with the required information : title, author, rating (optional).
	 */
	public void addBook() {
		
	}
	
	/*
	 * Not sure if a String is appropriate-- but set the book that they Search() for
	 * to read , but there could be more than one book listed, so then another search
	 * is made to get one book. Then you display the text they want to read based
	 * on the book and close it at the end.
	 */
	public String setToRead() {
		return null;
		
	}
	/*
	 * This function is used to search(), once book is found.
	 * Ask user for the rating 1-5 stars (check for valid input).
	 */
	public void rate() {
		
		
	}
	
	/*
	 * This uses the arraylist of books and displays the books
	 * sorted by title, then author, then if read or not. I think
	 * everything should be printed and each book in a new line.
	 */
	public void getBooks() {
		
		
	}
	
	/*
	 * From a list of unread books, we can use random int to choose
	 * what book to reccomend the user. Display the title and author.
	 */
	
	public void suggestRead() {
		
		
	}
	/*
	 * This is similar to addBook, but this time we are taking a whole text file
	 * then merging both of the lists of books so that the books are added.
	 */
	public void addBooks(String fileName) {
		try {
			
		} catch{}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}