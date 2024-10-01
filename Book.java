
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
		controller.setRead(read);
	}

	// Getters
	public String getTitle() {
		return title;
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
}
