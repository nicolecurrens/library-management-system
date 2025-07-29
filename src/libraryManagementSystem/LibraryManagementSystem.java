package libraryManagementSystem;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		// Set up users
		User u = new User("Nicole Currens", "123 Main St.", "512-499-2222");
		User u1 = new User("Pedro Pascal", "456 Pine St", "713-785-4899");
		User u2 = new User("Elmo", "123 Sesame St.", "111-111-1111", true);
		
		User[] users = {u, u1, u2};
		
		// Set up materials
		Book catch22 = new Book("Catch 22", 22.00);
		Book warAndPeace = new Book("War and Peace", 30.50);
		Book sl5 = new Book("Slaughterhouse 5", 15.75);
		Book plato = new Book("Plato's Republic", 25.75);
		AV dune = new AV("Dune Part I", 12.30);
		AV parasite = new AV("Parasite", 15.00);
		AV whiteAlbum = new AV("White Album", 10.50);
		warAndPeace.updateBestsellerStatus(true);
		
		Materials[] materials = {catch22, warAndPeace, sl5, plato, dune, parasite, whiteAlbum};
		
		LibraryManagerDisplay lmd = new LibraryManagerDisplay(users, materials);
		User currentUser = lmd.displayUserSelection();
		
		int choice = lmd.displayMainMenu();
		
		lmd.directToSubMenu(choice, currentUser);
		
		// TODO handle exiting program, or should display do that?
	}

}
