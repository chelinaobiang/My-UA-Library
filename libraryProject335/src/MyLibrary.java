
/* Genesis Benedith & Chelina Obiang
 * Course: CSC 335 - Fall 2024
 * This file contains a main method that runs a text-based 
 * user interface where the user can enter commands to get 
 * or add information to the library
 */
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyLibrary {
	private Scanner scanner;
	private static MyLibraryModel model;
	private static MyLibraryController controller;

	public MyLibrary() {

	}

	public static void main(String[] args) { //does it have to be static? I'm getting errors for try/catch.
		model = new MyLibraryModel();
		controller = new MyLibraryController(model);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the UA Library!\n");
		
		while(!controller.isSatisfied()) {
			System.out.println("What would you like to do? Enter a number from 1-7 for the following commands:");
			System.out.println("1- search, 2- rate, 3- add a book, 4- add books, 5- read book, 6- get list of books, 7- get suggested book");
			
			int command;
			boolean validCommand = false;
			
			while (!validCommand) {
				try {
					command = Integer.parseInt(scanner.nextLine().trim());
					if (command > 0 && command < 8) {
						validCommand = true;
						switch (command) {
							case 1: // Search library by various search types
								
								Book book = model.searchBooks();
				                break;
							
							case 2: // Rate's a book, if found
								
								book = model.searchBookByTitle();
								if (book == null) {
									System.out.println("Would you like to search again? (y/n)");
									scanner = new Scanner(System.in);
									String searchAgain = scanner.nextLine().toLowerCase().trim(); 
								    if (searchAgain.equals("y")) {
				                        book = model.searchBookByTitle(); // Call the search again
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
								break;
								
							case 4: 
								
								controller.addBooks();
								break;
							
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
								break;
								
							case 7:
								
								model.suggestRead();
								break;
						}
					} else {
						System.out.println("Invalid command. Enter a number from 1-7.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid command. Enter a number from 1-7.");
//					command = scanner.nextInt();
				}
				
			}
			
			System.out.println("Is there anything else you would like to do? (y/n)");
			scanner = new Scanner(System.in);

			String answer = scanner.nextLine().toLowerCase();
			if(answer.equals("n")) {
				controller.setSatisfaction(); // Sets satisfaction to true b/c they don't want to do anything else
				System.out.println("Thanks for visiting the UA Library!");
			}
	}
	scanner.close();
	System.exit(0);
}}
