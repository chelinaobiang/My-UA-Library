/* Genesis Benedith & Chelina Obiang
 * Course: CSC 335 - Fall 2024
 * Test change
 * This file contains a main method that runs a text-based 
 * user interface where the user can enter commands to get 
 * or add information to the library
 */
import java.io.File;
import java.util.Scanner;
public class MyLibrary{
	private Scanner scanner;
	private MyLibraryModel model;
	private MyLibraryController control;
	
	public MyLibrary(){
		
	}
	public void main(String[] args) {
		control = new MyLibraryController();
		model = new MyLibraryModel();
		
	}
	
	/*
	 * The user will search for a book based on book title, author, or rating.
	 * We can make this interactive to where there can be questions asked about what you
	 * will want to search for instead of confusing an invalid input.
	 */
	public void Search() {
		System.out.println("What book would you like to search for: ");
		scanner = new Scanner(System.in);
		String search = scanner + "";
		model.findBook(search);
		scanner.close();
		
	}
	
	/*
	 * This is where the user will add a book to the library list
	 * with the required information : title, author, rating (optional).
	 */
	public void addBook() {
		System.out.println("Book to add (Title:Author): ");
		scanner = new Scanner(System.in);
		String addition = scanner + "";
		model.addBook(addition);
		scanner.close();
	}
	
	/*
	 * Not sure if a String is appropriate-- but set the book that they Search() for
	 * to read , but there could be more than one book listed, so then another search
	 * is made to get one book. Then you display the text they want to read based
	 * on the book and close it at the end.
	 */
	public String setToRead() {
		return null; //What are we using to read??
		
	}
	/*
	 * This function is used to search(), once book is found.
	 * Ask user for the rating 1-5 stars (check for valid input).
	 */
	public void rate() {
		System.out.println("What rating would you give it (1-5 stars: ");
		scanner = new Scanner(System.in);
		String rate = scanner + "";
		int rating = Integer.parseInt(rate);
		model.addRate(rating);
	}
	
	/*
	 * This uses the arraylist of books and displays the books
	 * sorted by title, then author, then if read or not. I think
	 * everything should be printed and each book in a new line.
	 */
	public void getBooks() {
		System.out.println("These are the books in your Library:");
		for()
	}
	
	/*
	 * From a list of unread books, we can use random int to choose
	 * what book to recommend the user. Display the title and author.
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