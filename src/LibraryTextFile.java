import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryTextFile {

	private static Path filePath = Paths.get("Library.txt");

	/*
	 * public static void appendToFile(Library library) throws IOException { if
	 * (Files.notExists(filePath)) { Files.createFile(filePath); }
	 * 
	 * String library1 = library.getTitle() + ", " + library.getAuthor();
	 * List<String> libraryList = Arrays.asList(library1);
	 * 
	 * Files.write(filePath, libraryList, StandardOpenOption.APPEND);
	 * 
	 * }
	 */

	public static List<Library> readFile() throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		List<Library> library = new ArrayList<>();

		for (String line : lines) {
			String[] parts = line.split(",");
			Library c = new Library(parts[0], (parts[1]), (parts[2]), (parts[3]));
			library.add(c);
		}
		return library;

	}

}