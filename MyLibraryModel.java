

/*
 * This is where the searching, sorting, reading, and random suggest can be made.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random; // Needs to be in controller

public class MyLibraryModel{
	
	private Scanner scanner;
	private Book book;
	private ArrayList<Book> library = new ArrayList<>();
	public MyLibraryModel() {
		Book book;
	}
	public void addFromFile(String line) { //Adding the books for the 1st time in library.
		line.strip();
		String[] info = line.split(";");
		book = new Book(info[0], info[1], 0, false);
		library.add(book);
	}
	
	/*
	 * The user will search for a book based on book title, author, or rating. We
	 * can make this interactive to where there can be questions asked about what
	 * you will want to search for instead of confusing an invalid input.
	 */
	public void Search() {
		System.out.println("How would you like to search for your book? (Title or Author or Rating): ");
		scanner = new Scanner(System.in);
		String search = scanner + "";
		if(search.equals("Title") || search.equals("Author") || search.equals("Rating")) {
			searchType(search);
		}
		else {
			System.out.println("Error: You didn't type the given options.");
			Search();
		}
		scanner.close();

	}
	private void searchType(String type) {
		type.toLowerCase().strip();
		System.out.println("What would you like to find?: ");
		scanner = new Scanner(System.in);
		String data = scanner + "";
		if(type.equals("Title")) {
			for(Book book: library) {
				if(data.equals(book.getTitle())) {
				System.out.println( book.toString());
				}
			}
		}
		else if(type.equals("Author")) {
			for(Book book: library) {
				if(data.equals(book.getAuthor())) {
				System.out.println( book.toString());
				}
			}
		}
		else if(type.equals("Rating")) {
			for(Book book: library) {
				int iData = Integer.parseInt(data);
				if(iData ==book.getRating()) {
				System.out.println(book.toString());
				}
			}
		}
	}

	/*
	 * This is where the user will add a book to the library list with the required
	 * information : title, author, rating (optional).
	 */
	public void addBook() {
		System.out.println("Book to add in format (Title:Author): ");
		scanner = new Scanner(System.in);
		String addition = scanner + "";
		if (!addition.contains(":")) {
			System.out.println("Error, wrong input form.");
			addBook();
		}
		String[] parts = addition.split(":");
		if (parts[0] == null || parts[1] == null) {
			System.out.println("Error, wrong input form.");
			addBook();
		}
		
		book = new Book(parts[0], parts[1], 0, false);
		library.add(book);
		
		scanner.close();
	}

	/*
	 * Not sure if a String is appropriate-- but set the book that they Search() for
	 * to read , but there could be more than one book listed, so then another
	 * search is made to get one book. Then you display the text they want to read
	 * based on the book and close it at the end.
	 */
	public void setToRead() {
		book.setRead(); // What are we using to read??

	}

	/*
	 * This function is used to search(), once book is found. Ask user for the
	 * rating 1-5 stars (check for valid input).
	 */
	public void rate(Book book) {
		System.out.println("What rating would you give it (1-5) stars: ");
		scanner = new Scanner(System.in);
		String rate = scanner + "";
		int rating = Integer.parseInt(rate);
		book.setRate(rating);
	}

	/*
	 * This uses the arraylist of books and displays the books sorted by title, then
	 * author, then if read or not. I think everything should be printed and each
	 * book in a new line.
	 */
	public void getBooks() {
		System.out.println("How do you want to access your books -> Title, Author, Rating, Read or Unread");
		scanner = new Scanner(System.in);
		String form = scanner + "";
		if (form.equals("Title") || form.equals("Author") || form.equals("Rating") || form.equals("Read")
				|| form.equals("Unread")) {
			formatBooks(form);
		}
		else {
			System.out.println("Error: You didn't type the given options.");
			getBooks();
		}
		scanner.close();
	}
	private void formatBooks(String form) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * From a list of unread books, we can use random int to choose what book to
	 * recommend the user. Display the title and author.
	 */

//	public void suggestRead() {
//		System.out.println("The book I recommend
//	}

}
	
