import java.util.Date;

public class Library {

	private String title;
	private String author;
	private int status;
	private Date dueDate;

	public Library() {

	}

	public Library(String author) {
		super();
		this.author = author;
	}

	public Library(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date isDueDate(Date dueDate) {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return (title + " by: " + author);
	}

}
