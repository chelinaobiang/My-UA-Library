
/**
 * The MyLibraryController class manages a few of the operations for a library system,
 * interacting with the Model and handling functionalities related to books in the library.
 *
 * Attributes:
 * - satisfied (boolean): Indicates whether the user is satisfied with the library commands.
 * - model (MyLibraryModel): The model that represents the library's data.
 * - book (Book): A temporary Book object used for recommendations or additions.
 * - input (Scanner): A Scanner for user input from the console for interactions.
 *
 * Methods:
 * - isSatisfied: Returns the current satisfaction status of the user.
 * - setSatisfaction: Sets the satisfaction status to true to end program.
 * - getAllUnreadBooks: Returns a sorted list of all unread books in the library.
 * - getAllreadBooks: Returns a sorted list of all read books in the library.
 * - suggestRead: Suggests a random unread book from the library.
 * - addBooks: Adds books to the library from a specified text file, skipping headers
 *   and parsing each book's title and author gathered from each line.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MyLibraryController {

	private boolean satisfied = false;
	private MyLibraryModel model;
	private Book book;
	private Scanner scanner;

	public MyLibraryController(MyLibraryModel model) {
		this.model = model;
	}

	/*
	 * Checks if the user is satisfied with the library experience. Then returns
	 * true if the user is satisfied; false otherwise.
	 */
	public boolean isSatisfied() {
		return this.satisfied;
	}

	/*
	 * Converts the satisfaction to true.
	 */
	public void setSatisfaction() {
		this.satisfied = true;
	}


	/*
	 * Adds multiple books to the library from a specified text file.
	 * 
	 * This method prompts the user for a text file name, reads the file line by
	 * line, and parses each line to extract book titles and authors. Each book is
	 * created as a new Book object with a default rating of 0 and a read status of
	 * false, and then added to the library's collection.
	 * 
	 * The method skips the first line of the file, which is assumed to contain
	 * headers. If a line does not contain exactly two pieces of information (title
	 * and author), that line is ignored.
	 * 
	 * If the specified file cannot be found, an error message is displayed.
	 * 
	 * Parameter: fileName The name of the text file containing book data. The
	 * expected format for each line is "title;author".
	 */
	public void addBooks() {
		ArrayList<Book> library = model.getLibrary();

		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Type the name of the text file that contains the books you would like to add: ");
		String fileName = inputScanner.nextLine();

		int booksAdded = 0;

		try {
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] details = line.split(";");
				if (details.length == 2) {
					String title = details[0].toLowerCase().trim();
					String author = details[1].toLowerCase().trim();
					book = new Book(title, author, 0, false);
					library.add(book);
					booksAdded++;
				} else {
					System.out.println("Skipping invalid line: " + line);
				}
			}
			fileScanner.close();
			System.out.println("Books added successfully: " + booksAdded + " book(s).");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
	}
	
	/*
	 * This is where the user will add a book to the library list with the required
	 * information : title, author, rating (optional).
	 */
	public void addBook() {
		ArrayList<Book> library = model.getLibrary();
		
		System.out.println("What is the title of the book you would like to add?");
		scanner = new Scanner(System.in);
		String title = scanner.nextLine().toLowerCase();

		System.out.println("Who is the author of the book you would like to add?");
		scanner = new Scanner(System.in);
		String author = scanner.nextLine().toLowerCase();

		boolean readStatus = false;

		System.out.println("Have you read this book already? (y/n)");
		scanner = new Scanner(System.in);

		boolean validCommand = false;
		String read;

		while (!validCommand) {
			read = scanner.nextLine().toLowerCase();
			if (read.equals("y")) {
				readStatus = true;
				validCommand = true;
			} else if (read.equals("n")) {
				validCommand = true;
			} else {
				System.out.println("Invalid input. Please enter y or n.");
			}
		}

		System.out.println("Would you like to rate this book now? (y/n)");
		scanner = new Scanner(System.in);

		validCommand = false;
		int rating = 0;

		while (!validCommand) {
			String rate = scanner.nextLine().toLowerCase();
			if (rate.equals("y")) {
				System.out.println("How many stars would you like to rate this book? (1-5)");

				while (!validCommand) {
					try {
						rating = Integer.parseInt(scanner.nextLine().trim());
						if (rating < 1 || rating > 5) {
							System.out.println("Invalid input. Please enter a rating between 1 and 5.");
						} else {
							validCommand = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a number between 1 and 5.");
					}
				}
			} else if (rate.equals("n")) {
				validCommand = true;
			} else {
				System.out.println("Invalid input. Please enter y or n.");
			}
		}

		book = new Book(title, author, rating, readStatus);
		library.add(book);
		System.out.println("Book successfully added.");
		
		
	}
}
