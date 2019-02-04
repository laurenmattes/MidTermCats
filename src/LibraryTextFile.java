import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTextFile {

	private static Path filePath = Paths.get("NonFiction.txt");
	private static Path filePath2 = Paths.get("Fiction.txt");

	public static void appendToFile(Library library) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}

		String library1 = library.getTitle() + ", " + library.getAuthor();
		List<String> libraryList = Arrays.asList(library1);

		Files.write(filePath, libraryList, StandardOpenOption.APPEND);

	}

	public static List<Library> readFile() throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		List<Library> library = new ArrayList<>();

		for (String line : lines) {
			String[] parts = line.split(",");
			Library c = new Library(parts[0], (parts[1]));
			library.add(c);
		}
		return library;

	}

	public static List<Library> readFile2() throws IOException {
		List<String> lines = Files.readAllLines(filePath2);
		List<Library> library = new ArrayList<>();

		for (String line : lines) {
			String[] parts = line.split(",");
			Library c = new Library(parts[0], (parts[1]));
			library.add(c);
		}
		return library;

	}

}