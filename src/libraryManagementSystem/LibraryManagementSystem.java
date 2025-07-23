package libraryManagementSystem;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		User u = new User("Nicole Currens", "123 Main St.", "512-499-2222");
		User u1 = new User("Pedro Pascal", "456 Pine St", "713-785-4899");
		
		User[] users = {u, u1};
		
		LibraryManagerDisplay lmd = new LibraryManagerDisplay(users);
		User currentUser = lmd.displayUserSelection();
		
		int choice = lmd.displayMainMenu();
		
	}

}
