import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTextFile {

	private static Path filePath = Paths.get("Library.txt");

	// append textfile
	public static void appendToFile(Book book) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		String line = book.getTitle() + "," + book.getAuthor() + "," + book.getStatus() + "," + book.getDueDate();

		List<String> lineList = Arrays.asList(line);

		Files.write(filePath, lineList, StandardOpenOption.APPEND);
	}

	// truncate file with user changes
	public static void trunk(List<Book> booklist) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		List<String> listOfLines = new ArrayList<>();

		for (Book b : booklist) {

			String title = b.getTitle();
			String author = b.getAuthor();
			String status = b.getStatus();
			String dueDate = b.getDueDate();

			listOfLines.add(title + "," + author + "," + status + "," + dueDate);
		}
		Files.write(filePath, listOfLines, StandardOpenOption.TRUNCATE_EXISTING);
	}

	// readfile and store in list
	public static List<Book> readFile() throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		List<Book> library = new ArrayList<>();

		for (String line : lines) {
			String[] parts = line.split(",");
			Book c = new Book(parts[0], parts[1], parts[2], parts[3]);
			library.add(c);
		}
		return library;
	}
}