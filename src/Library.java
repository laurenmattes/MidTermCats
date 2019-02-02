
public class Library {

	private String Title;
	private String Author;
	private int Status;
	private boolean dueDate;

	public Library() {

	}

	public Library(String title, String author, int status, boolean dueDate) {
		super();
		Title = title;
		Author = author;
		Status = status;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public boolean isDueDate() {
		return dueDate;
	}

	public void setDueDate(boolean dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Library [Title=" + Title + ", Author=" + Author + ", Status=" + Status + ", dueDate=" + dueDate + "]";
	}

}
