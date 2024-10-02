
public class Book {
	private String title;
	private String author;
	private int rating;
	private MyLibraryController controller;
	public boolean read;

	// Constructor
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
		return read;
	}

	public void setRead() {
		read = true;
		
	}

	public void setRate(int rating2) {
		rating = rating2;
		
	}
=======
>>>>>>> 694bd244e1b6d53060f5f1acde9790845f968a43
}
