import java.util.Date;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		String title;
		String author;
		String status;
		Date dueDate;
		String userContinue = "n";
		int menuChoice;

		System.out.println("Welcome to the Cat's Library\n");
		printMenu();

		while (userContinue.equalsIgnoreCase("n")) {

			System.out.println(printMenu());

			userContinue = Validator.getString(scnr, "Leave the library? (y/n):");

		}

	}

	private static String printMenu() {

		return "1. Display entire list of books\n" + "2. Search by author\n" + "3. Search by title keyword";

	}

}
