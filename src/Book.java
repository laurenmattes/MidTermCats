
public class Book {

	private String title;
	private String author;
	private String status;
	private String dueDate;

	public Book() {

	}

	public Book(String author) {
		super();

		this.author = author;
	}

	public Book(String title, String author, String status, String dueDate) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return (title + " by: " + author + "due back: " + dueDate);
	}

}
