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
		int selection;
		String author;
		String title;
		String status;
		String dueDate;
		int sum = 0;

		System.out.println("\nWelcome to the Cat's Library");
		System.out.println("=============================");
		System.out.println("CHOOSE option [1-5]:\n");

		while (userContinue.equalsIgnoreCase("n")) {
			List<Book> listOfBooks = LibraryTextFile.readFile();

			menuChoice = Validator.getInt(scnr, "1. DISPLAY all books\n" + "2. Search by AUTHOR\n"
					+ "3. Search by TITLE KEYWORD\n" + "4. ADD a book to the Library\n" + "5. RETURN a book\n", 1, 5);

			if (menuChoice == 1) {

				// print entire list
				for (Book c : listOfBooks) {
					System.out.println(c.getTitle() + " by: " + c.getAuthor());
				}

				// get user input
				selection = Validator.getInt(scnr, "\nEnter the number to check out a book:", 1, listOfBooks.size());

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle().substring(3) + " is "
							+ listOfBooks.get(selection - 1).getStatus() + " and due back:"
							+ listOfBooks.get(selection - 1).getDueDate());
				} else {

					// update status+due date
					listOfBooks.get(selection - 1).setStatus("Checked Out");
					listOfBooks.get(selection - 1).setDueDate(rightNow());

					System.out.println("You " + listOfBooks.get(selection - 1).getStatus() + " "
							+ listOfBooks.get(selection - 1).getTitle().toUpperCase().substring(3)
							+ " and it is due back: " + listOfBooks.get(selection - 1).getDueDate());

				}
				LibraryTextFile.trunk(listOfBooks);
			}

			if (menuChoice == 2) {

				String choice1 = Validator.getStringMatchingRegex(scnr, "Type an author's name", "[a-zA-Z]{0,100}");

				// print books matching user author
				for (int j = 0; j < listOfBooks.size(); j++) {

					while (listOfBooks.get(j).getAuthor().toLowerCase().contains(choice1.toLowerCase())) {

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

				selection = Validator.getInt(scnr, "\nEnter the number to check out a book: ", 1, listOfBooks.size());

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle().substring(3) + " is "
							+ listOfBooks.get(selection - 1).getStatus() + " and due back:"
							+ listOfBooks.get(selection - 1).getDueDate());
				} else {

					listOfBooks.get(selection - 1).setStatus("Checked Out ");
					listOfBooks.get(selection - 1).setDueDate(rightNow());

					System.out.println("You " + listOfBooks.get(selection - 1).getStatus()
							+ listOfBooks.get(selection - 1).getTitle().toUpperCase().substring(3)
							+ " and it is due back: " + listOfBooks.get(selection - 1).getDueDate());
				}
				LibraryTextFile.trunk(listOfBooks);
			}

			if (menuChoice == 3) {

				String choice2 = Validator.getStringMatchingRegex(scnr, "Enter a title keyword: ", "[a-zA-Z]{0,4805}");

				// print list of titles matching keyword
				for (int i = 0; i < listOfBooks.size(); i++) {

					if (listOfBooks.get(i).getTitle().toLowerCase().contains(choice2.toLowerCase())) {
						System.out.println(listOfBooks.get(i).getTitle());
					}
				}

				selection = Validator.getInt(scnr, "\nEnter the number to check out that book:", 1, listOfBooks.size());

				if (listOfBooks.get(selection - 1).getStatus().equalsIgnoreCase("Checked Out")) {

					System.out.println(listOfBooks.get(selection - 1).getTitle().substring(3) + " is already "
							+ listOfBooks.get(selection - 1).getStatus());
				} else {

					listOfBooks.get(selection - 1).setStatus("Checked Out");
					listOfBooks.get(selection - 1).setDueDate(rightNow());

					System.out.println("You " + listOfBooks.get(selection - 1).getStatus() + " "
							+ listOfBooks.get(selection - 1).getTitle().toUpperCase().substring(3)
							+ " and it is due back: " + listOfBooks.get(selection - 1).getDueDate());
				}
				LibraryTextFile.trunk(listOfBooks);
			}
			if (menuChoice == 4) {

				String selection1 = Validator.getString(scnr, "Enter the TITLE: ");
				String selection2 = Validator.getString(scnr, "Enter the AUTHOR: ");

				title = selection1;
				author = selection2;
				status = "On Shelf";
				dueDate = "0";

				Book c = new Book(listOfBooks.size() + 1 + ". " + title, author, status, dueDate);

				// add to end of textfile
				LibraryTextFile.appendToFile(c);
			}

			if (menuChoice == 5) {

				// print list of checked out books
				for (int a = 0; a < listOfBooks.size(); a++) {

					if (listOfBooks.get(a).getStatus().equals("Checked Out")) {
						System.out.println(listOfBooks.get(a).getTitle() + " by: " + listOfBooks.get(a).getAuthor());
					}
				}

				selection = Validator.getInt(scnr, "\nEnter a number to return that book: ", 1, listOfBooks.size());

				if (!listOfBooks.get(selection - 1).getStatus().equals("Checked Out")) {
					System.out.println("That book is still available!\n");
					continue;
				}
				System.out.println("Purrrfect! Thanks!");

				listOfBooks.get(selection - 1).setStatus("On Shelf");
				listOfBooks.get(selection - 1).setDueDate("0");

				LibraryTextFile.trunk(listOfBooks);
			}
			userContinue = Validator.getString(scnr, "\nLeave the library? (y/n):");
		}
		LibraryTextFile.readFile();
		System.out.println("\nCome back anytime, MEOW.");
		scnr.close();
	}

	public static String rightNow() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		LocalDate twoWeeks = localDate.plusWeeks(2);

		return dtf.format(twoWeeks);

	}

}
