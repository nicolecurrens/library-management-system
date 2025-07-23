package libraryManagementSystem;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		User u = new User("Nicole Currens", "123 Main St.", "512-499-2222");
		
		System.out.println("User name: " + u.name);
		System.out.println("User address: " + u.address);
		System.out.println("User phone: " + u.phone_number);
		System.out.println("User UUID: " + u.libraryCard.libraryCardID);
		
	}

}
