import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		String title;
		String author;
		String status;
		Date dueDate;
		String userContinue = "n";
		int menuChoice;

		List<Library> listOfBooks = LibraryTextFile.readFile();

		System.out.println("Welcome to the Cat's Library\n");

		while (userContinue.equalsIgnoreCase("n")) {

			menuChoice = Validator.getInt(scnr,
					"1. Display entire list of books\n" + "2. Search by author\n" + "3. Search by title keyword\n", 1,
					3);

			if (menuChoice == 1) {
				System.out.println("");

				for (Library c : listOfBooks) {
					System.out.println(c);
				}
			}

			if (menuChoice == 2) {

				for (Library c : listOfBooks) {
					System.out.println(c.getAuthor());
				}

			}
			if (menuChoice == 3) {

			}

			userContinue = Validator.getString(scnr, "Leave the library? (y/n):");

			System.out.println("Come back anytime.");

		}

	}

}
