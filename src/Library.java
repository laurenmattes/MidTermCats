
public class Library {

	private String title;
	private String author;
	private String status;
	private String dueDate;

	public Library() {

	}

	public Library(String author) {
		super();

	}

	public Library(String title, String author, String status, String dueDate) {
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

	public String isDueDate(String dueDate) {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return (title + " by: " + author);
	}

}
