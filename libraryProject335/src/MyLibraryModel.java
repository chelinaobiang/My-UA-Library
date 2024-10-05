
/*
 * This is where the searching, sorting, reading, and random suggest can be made.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

public class MyLibraryModel {

	private Scanner scanner;
	private Book book;
	private ArrayList<Book> library = new ArrayList<>();
	private MyLibraryController controller;

	public MyLibraryModel() {
        this.library = new ArrayList<>();
    }
	
	public ArrayList<Book> getLibrary() {
        return library;
    }

	/*
	 * The user will search for a book based on book title, author, or rating. We
	 * can make this interactive to where there can be questions asked about what
	 * you will want to search for instead of confusing an invalid input.
	 */
	public Book searchBooks() {
		System.out.println("How would you like to search for your book? (Title, Author, or Rating): ");
	    scanner = new Scanner(System.in);
	    String searchType = scanner.nextLine().toLowerCase().trim();

	    Book result = null;
	    
	    switch (searchType) {
	        case "title":
	            result = searchBookByTitle();
	            break;
	        case "author":
	            result = searchBookByAuthor();
	            break;
	        case "rating":
	            result = searchBookByRating();
	            break;
	        default:
	            System.out.println("Error: Invalid search type. Please try again.");
	            result = searchBooks();  // Call the search method again for a valid input
	    }

	    if (result == null) {
			System.out.println("Would you like to search again? (y/n)");
			scanner = new Scanner(System.in);
			String searchAgain = scanner.nextLine().toLowerCase().trim(); 
		    if (searchAgain.equals("y")) {
                searchBooks(); // Call the search again
            } else {
            	System.out.println("No book selected. Returning to the main menu.");
            }
        } else {
        	System.out.println("Found the book: " + result.getTitle());
        }
	    return result;

	}

	Book searchBookByTitle() {
		// Get book title from user
		System.out.println("What is the title of the book you'd like to search for?");
		scanner = new Scanner(System.in);
		String title = scanner.nextLine().toLowerCase().trim();
		ArrayList<Book> booksFound = new ArrayList<>(); // Create empty array list to store books with matching data

		// Search through entire library for books with given title and add to
		// booksFound list
		for (Book book : library) {
			if (title.equals(book.getTitle().toLowerCase().trim())) {
				booksFound.add(book);
			}
		}

		// If booksFound list is empty, then print message and return null
		if (booksFound.isEmpty()) {
			System.out.println("No books found with the title: " + title);
			return null;
		}

		// If size of booksFound list is 1, then return found book
		if (booksFound.size() == 1) {
			System.out.println("Found one book: " + booksFound.get(0).toString());
			return booksFound.get(0);
		}

		// If there are multiple books with same title, print books as a numbered list
		System.out.println("Multiple books found with the title '" + title + "':");
		for (int i = 0; i < booksFound.size(); i++) {
			Book bookFound = booksFound.get(i);
			System.out.println((i + 1) + ". " + bookFound.getTitle() + " by " + bookFound.getAuthor());
		}

		// Narrow search by getting book author
		System.out.println("Who is the author of the book you are searching for?");
		System.out.println("Please enter their name to narrow search:");
		String author = scanner.nextLine().toLowerCase().strip();

		// Look through the list of books found
		for (Book book : booksFound) {
			// Check if there is a book with the matching author
			if (author.equals(book.getAuthor().toLowerCase().strip())) {
				System.out.println("Found the book: " + book);
				return book;
			}
		}

		// Return null if there is no book with given author and book title
		System.out.println("No book found with the title '" + title + "' and author '" + author + "'.");
		return null;
	}

	Book searchBookByAuthor() {
		// Get author name from user
		System.out.println("Who is the author of the book you'd like to search for?");
		scanner = new Scanner(System.in);
		String author = scanner.nextLine().toLowerCase().trim();

		ArrayList<Book> booksFound = new ArrayList<>(); // Create empty array list to store books with matching data

		// Search through entire library for books by given author and add to booksFound
		// list
		for (Book book : library) {
			if (author.equals(book.getAuthor().toLowerCase().trim())) {
				booksFound.add(book);
			}
		}

		// If booksFound list is empty, then print message and return null
		if (booksFound.isEmpty()) {
			System.out.println("No books found with the author: " + author);
			return null;
		}

		// If size of booksFound list is 1, then return found book
		if (booksFound.size() == 1) {
			System.out.println("Found one book: " + booksFound.get(0).toString());
			return booksFound.get(0);
		}

		// If there are multiple books by same author, print books as a numbered list
		System.out.println("Multiple books found with the author '" + author + "':");
		for (int i = 0; i < booksFound.size(); i++) {
			Book bookFound = booksFound.get(i);
			System.out.println((i + 1) + ". " + bookFound.getTitle() + " by " + bookFound.getAuthor());
		}

		// Narrow search by getting book title
		System.out.println("What is the of the book you are searching for?");
		System.out.println("Please enter the title to narrow search:");
		String title = scanner.nextLine().toLowerCase().strip();

		// Look through the list of books found
		for (Book book : booksFound) {
			// Check if there is a book with a matching title
			if (title.equals(book.getTitle().toLowerCase().strip())) {
				System.out.println("Found the book: " + book);
				return book;
			}
		}

		// Return null if there is no book with given author and book title
		System.out.println("No book found with the author '" + author + "' and title '" + title + "'.");
		return null;
	}

	Book searchBookByRating() {
		// Get rating from user
		System.out
				.println("How many stars has the book been rated? Enter a digit between 0-5 (0 is for unrated books)");
		scanner = new Scanner(System.in);
		int rating;

		// Validate input and make sure integer is between 0 and 5
		while (true) {
			try {
				rating = Integer.parseInt(scanner.nextLine().trim());
				if (rating < 0 || rating > 5) {
					System.out.println("Invalid input. Please enter a rating between 0 and 5.");
				} else {
					break; // Exit loop if input is valid
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number between 0 and 5.");
				scanner.next(); // Clear invalid input
			}

		}

		ArrayList<Book> booksFound = new ArrayList<>(); // Create empty array list to store books with matching data

		// Search through entire library for books with given rating and add to
		// booksFound list
		for (Book book : library) {
			if (rating == book.getRating()) {
				booksFound.add(book);
			}
		}

		// If booksFound list is empty, then print message and return null
		if (booksFound.isEmpty()) {
			System.out.println("No books found with " + Integer.toString(rating) + " stars.");
			return null;
		}

		// If size of booksFound list is 1, then return found book
		if (booksFound.size() == 1) {
			System.out.println("Found one book: " + booksFound.get(0).toString());
			return booksFound.get(0);
		}

		// If there are multiple books with same rating, print books as a numbered list
		System.out.println("Multiple books found with " + Integer.toString(rating) + " stars:");
		for (int i = 0; i < booksFound.size(); i++) {
			Book bookFound = booksFound.get(i);
			System.out.println((i + 1) + ". " + bookFound.getTitle() + " by " + bookFound.getAuthor());
		}

		// Narrow search by getting book title
		System.out.println("What is the of the book you are searching for?");
		System.out.println("Please enter the title to narrow search:");
		String title = scanner.nextLine().toLowerCase().strip();

		// Also narrow search by getting book author
		System.out.println("Who is the author of the book you'd like to search for?");
		System.out.println("Please enter the author's name to narrow search:");
		String author = scanner.nextLine().toLowerCase().strip();

		// Look through the list of books found
		for (Book book : booksFound) {
			// Check if there is a book with a matching title
			if (title.equals(book.getTitle().toLowerCase().trim())
					&& author.equals(book.getAuthor().toLowerCase().trim())) {
				System.out.println("Found the book: " + book.toString());
				return book;
			}
		}

		// Return null if there is no book with given rating, author or book title
		System.out.println("No book found with the given data.");
		return null;
	}

	/*
	 * This is where the user will add a book to the library list with the required
	 * information : title, author, rating (optional).
	 */
	public void addBook() {
		System.out.println("What is the title of the book you would like to add?");
		scanner = new Scanner(System.in);
		String title = scanner.nextLine().toLowerCase();
		
		System.out.println("Who is the author of the book you would like to add?");
		scanner = new Scanner(System.in);
		String author = scanner.nextLine().toLowerCase();
		
		System.out.println("Have you read this book already? (y/n)");
		scanner = new Scanner(System.in);
		String read = scanner.nextLine().toLowerCase();
		boolean readStatus = false;
		if (read.equals("y")) {
			readStatus = true;
		} 
		
		System.out.println("Would you like to rate this book now? (y/n)");
		scanner = new Scanner(System.in);
		String rate = scanner.nextLine().toLowerCase();
		int rating = 0;
		if (rate.equals("y")) {
			while (true) {
				try {
					System.out.println("How many stars would you like to rate this book? (1-5)");
					scanner = new Scanner(System.in);
					rating = Integer.parseInt(scanner.nextLine().trim());
					if (rating < 1 || rating > 5) {
						System.out.println("Invalid input. Please enter a rating between 1 and 5.");
					} else {
						break; // Exit loop if input is valid
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number between 1 and 5.");
					scanner.next(); // Clear invalid input
				}

			}
		}
		
		book = new Book(title, author, rating, readStatus);
		library.add(book);
		System.out.println("Book successfully added.");

	}

	/*
	 * Not sure if a String is appropriate-- but set the book that they Search() for
	 * to read , but there could be more than one book listed, so then another
	 * search is made to get one book. Then you display the text they want to read
	 * based on the book and close it at the end.
	 */
	public void readBook(Book book) {		
		book.setRead(); 

	}

	/*
	 * This function is used to search(), once book is found. Ask user for the
	 * rating 1-5 stars (check for valid input).
	 */
	public void rateBook(Book book) {
		System.out.println("What rating would you give it (1-5) stars: ");
		scanner = new Scanner(System.in);
		String rate = scanner + "";
		int rating = Integer.parseInt(rate);
		book.setRate(rating);
	}

	/*
	 * This uses the array list of books and displays the books sorted by title, then
	 * author, then if read or not. I think everything should be printed and each
	 * book in a new line.
	 */
	public void getBooks() {
		System.out.println("To view books in this library, choose one of the following options (1-4):\n");
		System.out.println("1. Titles in alphabetical order");
		System.out.println("2. Authors in alphabetical order");
		System.out.println("3. All unread books");
		System.out.println("4. All read books");
		
		scanner = new Scanner(System.in);
		int option; 
		
		while (true) {
			try {
				option = Integer.parseInt(scanner.nextLine().trim());
				if (option < 1 || option > 4) {
					System.out.println("Invalid input. Please enter a rating between 1 and 4.");
				} else {
					if (option == 1) {
						
					} else if (option == 2) {
						
					} else if (option == 3) {
						
					} else {
						
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 4.");
				scanner.next(); // Clear invalid input
			}

		}
		
		ArrayList<Book> libraryCopy = getLibrary();
		
		for (Book book : libraryCopy) {
			System.out.println(book.getTitle());
		}
	}


}
