/**
 *  Authors: Genesis Benedith & Chelina Obiang
 * This class is where the tracking, getting, and setting of the individual
 * book objects is going to be. This is important to the front and backend
 * because the project revolves mostly on the indivitual books.
 */
public class Book {
	private String title;
	private String author;
	private int rating;
	private MyLibraryController controller;
	public boolean read;

	// Constructor for the book information
	public Book(String title, String author, int rating, boolean read) {
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.read = read;
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public String toString() {
		String str = "";
		str += title + " by: " + author + " ( " + getStrRating() + " )";
		return str;
	}
	
	//Turns the rate int into a string
	public String getStrRating(){
		return ("*".repeat(rating));
	}

	public String getAuthor() {
		return author;
	}

	public int getRating() {
		return rating;
	}

	public boolean isRead() {
		return this.read;
	}
	
	//Setters
	public void setRead() {
<<<<<<< Updated upstream:libraryProject335/Book.java
		this.read = true;
		
	}

	public void setRate(int rating2) {
		this.rating = rating2;
		
	}

}
=======
		controller.makeRead(true);

	}
}
>>>>>>> Stashed changes:Book.java
