package libraryManagementSystem;
import java.time.LocalDate;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		// Set up users
		User u = new User("Jenna Ortega", "123 Main St.", "512-499-2222", 20);
		User u1 = new User("Pedro Pascal", "456 Pine St", "713-785-4899", 20);
		User u2 = new User("Elmo", "123 Sesame St.", "111-111-1111", 5); // Child user
		
		User[] users = {u, u1, u2};
		
		// Set up loanable materials
		Book catch22 = new Book("Catch 22", 22.00);
		Book warAndPeace = new Book("War and Peace", 30.50);
		Book court = new Book("A Court of Thorns and Roses", 25.00);
		Book sl5 = new Book("Slaughterhouse 5", 15.75);
		Book plato = new Book("Plato's Republic", 25.75);
		Book greenEgg = new Book("Green Eggs and Ham", 8.00);
		Book charlotte = new Book("Charlotte's Web", 9.00);
		Book moon = new Book("Goodnight Moon", 6.00);
		Book treasure = new Book("Treasure Island", 15.00);
		Book aesop = new Book("Aesop's Fables", 10.00);
		AV dune = new AV("Dune Part I", 12.30);
		AV parasite = new AV("Parasite", 15.00);
		AV whiteAlbum = new AV("White Album", 10.50);
		AV princess = new AV("Princess Bride", 17.00);
		AV sesameStreet = new AV("Sesame Street", 10.00);
		warAndPeace.updateBestsellerStatus(true);
		court.updateBestsellerStatus(true);
		
		// Set up unloanable materials
		ReferenceBook dict = new ReferenceBook("Oxford English Dictionary");
		ReferenceBook dewey = new ReferenceBook("Explaining the Dewey Decimal System");
		Magazine p = new Magazine("People", "Feb 2025");
		Magazine p1 = new Magazine("People", "Jan 2025");
		
		Materials[] materials = {catch22, warAndPeace, sl5, plato, dune, parasite, princess, court, 
				whiteAlbum, sesameStreet, greenEgg, charlotte, moon, treasure, aesop, dict, dewey, p, p1};
		
		// Set up Loans
		LoanManager loanManager = new LoanManager();
		loanManager.createLoan(u, plato, null);
		loanManager.createLoan(u, warAndPeace, null);
		loanManager.createLoan(u1, parasite, null);
//		loanManager.createLoan(u2, sesameStreet, null);
		loanManager.createLoan(u2, sesameStreet, LocalDate.of(2025, 6, 12));
		loanManager.createLoan(u2, greenEgg, null);
		loanManager.createLoan(u2,  charlotte, null);
		loanManager.createLoan(u2,  moon, null);
		loanManager.createLoan(u2, treasure, null);
		
		RequestManager rm = new RequestManager();
		Request r = new Request(u1, plato, rm);
		u1.addRequest(r);
		
		// Begin program
		LibraryManagerDisplay lmd = new LibraryManagerDisplay(users, materials, loanManager, rm);
		User currentUser = lmd.displayUserSelection();
		
		System.out.println("Welcome to the library management system, " + currentUser.name);
		currentUser.printUserInfo();
		
		while(true) {
			int choice = lmd.displayMainMenu();
			if(choice == 4) {
				System.out.println("Goodbye");
				System.exit(0);
			}
			
			lmd.directToSubMenu(choice, currentUser);
		
		}
	}

}
