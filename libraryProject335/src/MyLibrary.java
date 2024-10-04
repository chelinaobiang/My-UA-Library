/* Genesis Benedith & Chelina Obiang
 * Course: CSC 335 - Fall 2024
 * This file contains a main method that runs a text-based 
 * user interface where the user can enter commands to get 
 * or add information to the library
 */
import java.io.File;
import java.util.Scanner;

public class MyLibrary {
	private Scanner scanner;
	private static MyLibraryModel model;
	private static MyLibraryController controller;

	public MyLibrary() {
		controller = new MyLibraryController();
		model = new MyLibraryModel();
	}

	public static void main(String[] args) { //does it have to be static? I'm getting errors for try/catch.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the UA Library!");
		while(!controller.isSatisfied()) {
			System.out.print("What would you like to do? \n Enter a number from 1-7 for the following commands: (1- search, 2- rate, 3- add a book, 4- add books, 5- read book, 6- get list of books, 7- get suggested book)");
			int answer = scanner.nextInt();
			switch (answer) {
				case 1: // Call searchBooks to search library by various search types
					
					Book book = model.searchBooks();
					System.out.println(book.toString()); // Print string format of string details
				
				case 2: // Rate's a book, if found
					
					book = model.searchBookByTitle();
					if (book == null) {
						System.out.println("Would you like to search again? (y/n)");
						scanner = new Scanner(System.in);
					    String searchAgain = scanner.nextLine().toLowerCase().trim(); 
					    if (searchAgain.equals("y")) {
                            // Call the search again
                            book = model.searchBookByTitle();
                        }
                    }

                    if (book != null) {
                        model.rateBook(book);  // If a book is found, proceed with rating book
                    } else {
                        System.out.println("No book selected. Returning to the main menu.");
                    }
                    break;
				
				case 3:
					model.addBook();
				case 4: 
					controller.addBooks();
				
				case 5: // Changes a book's status to read if found
					
					book = model.searchBooks();
					if (book == null) {
						System.out.println("Would you like to search again? (y/n)");
						scanner = new Scanner(System.in);
					    String searchAgain = scanner.nextLine().toLowerCase().trim(); 
					    if (searchAgain.equals("y")) {
                            // Call the search again
                            book = model.searchBookByTitle();
                        }
                    }

                    if (book != null) {
                        model.readBook(book);  // If a book is found, proceed with changing book status to read
                    } else {
                        System.out.println("No book selected. Returning to the main menu.");
                    }
					
				case 6:
					model.getBooks();
				case 7:
					controller.suggestRead();
				default:
                    System.out.println("Invalid command. Try again.");
                    break;
			}
			System.out.print("Is there anything else you would like to do? (y/n)");
			String answer2 = scanner.nextLine().toLowerCase();
			if (answer2 == "n") {
				controller.setSatisfaction(); // Sets satisfaction to true bc they dont want to do anything else
			}
		}
		scanner.close();
	}
}

	