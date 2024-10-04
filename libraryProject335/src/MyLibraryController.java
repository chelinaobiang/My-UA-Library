package libraryProject335.src;
/*
 * This is where the rating and adding can be made.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
	 * This returns all of the unread books that are currently in the library so it gathers the library array
	 * and then sorts the books by title.
	 */
	public ArrayList<Book> getAllUnreadBooks(ArrayList<Book> library) {
		ArrayList<Book> unread = new ArrayList<>();
		for(Book b: library) {
			if(!b.isRead()) {
				unread.add(b);
			}
		}
		unread.sort((b1, b2) -> b1.titleCompareTo(b2));
		return unread;
	}
	/*
	 * This returns all of the read books that are currently in the library so it gathers the library array
	 * and then sorts the books by title.
	 */
	public ArrayList<Book> getAllreadBooks(ArrayList<Book> library) {
		ArrayList<Book> readBooks = new ArrayList<>();
		for(Book b: library) {
			if(b.isRead() == true) {
				readBooks.add(b);
			}
		}
		readBooks.sort((b1, b2) -> b1.titleCompareTo(b2));
		return readBooks;
	}
	/*
	 * This prints the recommended book based on the random selection of books that haven't beet read
	 * from the getAllUnreadBooks method.
	 */
	public void suggestRead() {
		ArrayList<Book> unread = getAllUnreadBooks(model.library);
		Random rand = new Random();
		int randomInt = rand.nextInt(unread.size());
		book = unread.get(randomInt);
		System.out.println("The book I recommend is :" + book.toString());
	}
	
	/*
	 * This is similar to addBook, but this time we are taking a whole text file
	 * then adding it to the lists of books so that the books are added.
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
	            	String author = info[1].trim();
	            	Book book = new Book(title, author, 0, false);
	            	model.library.add(book);
	            	scanner.close();
	            } 
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + e.getMessage());
	    }
	}
		
	







}
	
	
	
	
	
	
	
	
	
		

}
