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

		List<Library> listOfBooks = LibraryTextFile.readFile();

		System.out.println("Welcome to the Cat's Library\n");

		while (userContinue.equalsIgnoreCase("n")) {

			menuChoice = Validator.getInt(scnr,
					"1. Display entire list of books\n" + "2. Search by author\n" + "3. Search by title keyword\n", 1,
					3);

			if (menuChoice == 1) {
				System.out.println("");

				for (Library c : listOfBooks) {
					System.out.println(c.getTitle() + " by " + c.getAuthor());
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

				for (int j = 0; j < listOfBooks.size(); j++) {
					System.out.println(listOfBooks.get(j).getAuthor());
					j++;
				}

				String choice = Validator.getString(scnr, "Type an author's first name:");
				choice.toLowerCase();

				if (choice.startsWith("j")) {

					System.out.println(listOfBooks.get(0).getTitle() + "\n" + listOfBooks.get(1).getTitle());
				}
				if (choice.startsWith("h")) {

					System.out.println(listOfBooks.get(2).getTitle() + "\n" + listOfBooks.get(3).getTitle());
				}
				if (choice.startsWith("e")) {

					System.out.println(listOfBooks.get(4).getTitle() + "\n" + listOfBooks.get(5).getTitle());

				}
				if (choice.startsWith("c")) {

					System.out.println(listOfBooks.get(6).getTitle() + "\n" + listOfBooks.get(7).getTitle());

				}
				if (choice.startsWith("d")) {

					System.out.println(listOfBooks.get(8).getTitle() + "\n" + listOfBooks.get(9).getTitle());

				}
				if (choice.startsWith("s")) {

					System.out.println(listOfBooks.get(10).getTitle() + "\n" + listOfBooks.get(11).getTitle());

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

				String choice2 = Validator.getString(scnr, "Enter a title keyword.");
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
