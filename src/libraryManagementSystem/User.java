package libraryManagementSystem;

public class User {
	
	public String name;
	public String address;
	public String phone_number;
	public LibraryCard libraryCard;
	public boolean child;
	
	public User(String userName, String userAddress, String userPhone) {
		
		this.name = userName;
		this.address = userAddress;
		this.phone_number = userPhone;
		
		this.libraryCard = new LibraryCard();
		
		
	}

}
