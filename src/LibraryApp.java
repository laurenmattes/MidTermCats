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

				String choice = Validator.getString(scnr, "Type an author's first name:");
				choice.toLowerCase();

				if (choice.startsWith("j")) {

					System.out.println(listOfBooks.get(0) + "\n" + listOfBooks.get(1));
				}
				if (choice.startsWith("h")) {

					System.out.println(listOfBooks.get(2) + "\n" + listOfBooks.get(3));
				}
				if (choice.startsWith("e")) {

					System.out.println(listOfBooks.get(4) + "\n" + listOfBooks.get(5));

				}
				if (choice.startsWith("c")) {

					System.out.println(listOfBooks.get(6) + "\n" + listOfBooks.get(7));

				}
				if (choice.startsWith("d")) {

					System.out.println(listOfBooks.get(8) + "\n" + listOfBooks.get(9));

				}
				if (choice.startsWith("s")) {

					System.out.println(listOfBooks.get(10) + "\n" + listOfBooks.get(11));

				}
			}

			if (menuChoice == 3) {

				String choice2 = Validator.getString(scnr, "Enter a title keyword.");
				choice2.toLowerCase();

				for (int i = 0; i < listOfBooks.size(); i++) {

					if (listOfBooks.get(i).getTitle().toLowerCase().contains(choice2)) {
						System.out.println(listOfBooks.get(i).getTitle());
					}
				}

			}

			userContinue = Validator.getString(scnr, "Leave the library? (y/n):");

		}
		System.out.println("Come back anytime.");

	}

}
