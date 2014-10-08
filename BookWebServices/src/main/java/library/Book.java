package library;

public class Book {

	private final long id;
	private final String isbn;
	private String author;
	private String title;
	private int numSells;
	private String publishedDate;

	public Book(long id, String isbn, String title) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumSells() {
		return numSells;
	}

	public void setNumSells(int numSells) {
		this.numSells = numSells;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Book [id="
				+ id
				+ ", "
				+ (isbn != null ? "isbn=" + isbn + ", " : "")
				+ (author != null ? "author=" + author + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ "numSells="
				+ numSells
				+ ", "
				+ (publishedDate != null ? "publishedDate=" + publishedDate
						: "") + "]";
	}
}