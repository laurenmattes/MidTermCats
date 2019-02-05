import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		String userContinue = "n";
		int menuChoice;
		int selection = 0;

		String author = null;
		String title = null;
		String status = "On Shelf";
		String dueDate = "0";

		int sum = 0;

		System.out.println("Welcome to the Cat's Library\n");

		while (userContinue.equalsIgnoreCase("n")) {
			List<Library> listOfBooks = LibraryTextFile.readFile();

			menuChoice = Validator.getInt(scnr, "1. Display entire list of books\n" + "2. Search by author\n"
					+ "3. Search by title keyword\n" + "4. Add a book to the Library.", 1, 4);

			if (menuChoice == 1) {

				for (Library c : listOfBooks) {
					System.out.println(c.getTitle() + " by: " + c.getAuthor());
				}
				selection = Validator.getInt(scnr, "\nEnter number to check book out:");

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is "
							+ listOfBooks.get(selection - 1).getStatus());
				} else {

					listOfBooks.get(selection - 1).setStatus("Checked Out");

					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is now "
							+ listOfBooks.get(selection - 1).getStatus() + " and is due back:" + rightNow());
				}

			}

			if (menuChoice == 2) {

				String choice1 = Validator.getStringMatchingRegex(scnr, "Type an author's name", "[a-z]{0,100}");
				choice1.toLowerCase();

				for (int j = 0; j < listOfBooks.size(); j++) {

					while (listOfBooks.get(j).getAuthor().toLowerCase().contains(choice1)) {
						for (int k = 0; k < listOfBooks.size(); k++) {

							if (sum == 2) {
								break;
							}
							if (listOfBooks.get(k).getAuthor().contains(listOfBooks.get(j).getAuthor())) {
								System.out.println(listOfBooks.get(k).getTitle());
								sum++;
							}
						}
						break;
					}
				}

				selection = Validator.getInt(scnr, "Enter number to check book out");

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is "
							+ listOfBooks.get(selection - 1).getStatus());
				} else {

					listOfBooks.get(selection - 1).setStatus("Checked Out");
					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is now "
							+ listOfBooks.get(selection - 1).getStatus() + " and is due back:" + rightNow());
				}
			}

			if (menuChoice == 3) {

				String choice2 = Validator.getStringMatchingRegex(scnr, "Enter a title keyword.", "[a-z]{0,4805}");
				choice2.toLowerCase();

				for (int i = 0; i < listOfBooks.size(); i++) {

					if (listOfBooks.get(i).getTitle().toLowerCase().contains(choice2)) {
						System.out.println(listOfBooks.get(i).getTitle());
					}
				}
				selection = Validator.getInt(scnr, "Enter number to check book out");

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is "
							+ listOfBooks.get(selection - 1).getStatus());
				} else {

					listOfBooks.get(selection - 1).setStatus("Checked Out");
					System.out.println(listOfBooks.get(selection - 1).getTitle() + " is now "
							+ listOfBooks.get(selection - 1).getStatus() + " and is due back:" + rightNow());
				}

			}
			if (menuChoice == 4) {
				String selection1 = Validator.getString(scnr, "Enter a book title.");

				String selection2 = Validator.getString(scnr, "Enter the books author.");

				title = selection1;
				author = selection2;
				Library c1 = new Library(listOfBooks.size() + ". " + title, author, status, dueDate);
				LibraryTextFile.appendToFile(c1);

			}

			userContinue = Validator.getString(scnr, "\nLeave the library? (y/n):");
		}

		System.out.println("\nCome back anytime.");

	}

	public static String rightNow() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		LocalDate twoWeeks = localDate.plusWeeks(2);

		return dtf.format(twoWeeks); // 2016/11/16

	}

}
