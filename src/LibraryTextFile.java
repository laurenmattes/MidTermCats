import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTextFile {

	private static Path filePath = Paths.get("Library.txt");

	public static void rewrite() throws IOException {
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(filePath), charset);
		content = content.replace("Checked Out", "On Shelf");

		Files.write(filePath, content.getBytes(charset));

	}

	public static void reStatus() throws IOException {
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(filePath), charset);
		content = content.replace("On Shelf", "Checked Out");

		Files.write(filePath, content.getBytes(charset));

	}

	public static void reDate() throws IOException {
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(filePath), charset);
		content = content.replace("00/00/0000", "02/19/2019");

		Files.write(filePath, content.getBytes(charset));

	}

	public static void appendToFile(Library library) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		String Library = library.getTitle() + "," + library.getAuthor() + "," + library.getStatus() + ","
				+ library.getDueDate();

		List<String> libraryList = Arrays.asList(Library);

		Files.write(filePath, libraryList, StandardOpenOption.APPEND);

	}

	public static void sync(Library library) throws IOException {

		String Library = library.getTitle() + "," + library.getAuthor() + "," + library.getStatus() + ","
				+ library.getDueDate();
		List<String> libraryList = Arrays.asList(Library);

		Files.write(filePath, libraryList, StandardOpenOption.DSYNC);

	}

	public static List<Library> readFile() throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		List<Library> library = new ArrayList<>();

		for (String line : lines) {
			String[] parts = line.split(",");
			Library c = new Library(parts[0], parts[1], parts[2], parts[3]);
			library.add(c);
		}
		return library;

	}

}