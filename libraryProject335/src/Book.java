package libraryProject335.src;
public class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int rating;
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
		return this.read;
	}

	public void setRead() {
		this.read = true;
		
	}

	public void setRate(int rating2) {
		this.rating = rating2;
		
	}
	public int titleCompareTo(Book other) {
	    return this.title.compareTo(other.title);
	}
	public int authorCompareTo(Book other) {
	    return this.author.compareTo(other.author);
	}
	public int ratingCompareTo(Book other) {
	    return Integer.compare(this.rating, other.rating);  // Comparing books by rating (from 0 to 5)
	}

	@Override
	public int compareTo(Book o) {
		return this.titleCompareTo(o);
	}

}
