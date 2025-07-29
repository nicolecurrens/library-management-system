package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public String name;
	public String address;
	public String phone_number;
	public LibraryCard libraryCard;
	public boolean child = false;
	private List<Loan> loans;
	
	public User(String userName, String userAddress, String userPhone) {
		
		this.name = userName;
		this.address = userAddress;
		this.phone_number = userPhone;
		this.loans = new ArrayList<>();
		
		this.libraryCard = new LibraryCard();
	}
	
	public User(String userName, String userAddress, String userPhone, boolean child) {
		// Overloaded constructor for child user
		this.name = userName;
		this.address = userAddress;
		this.phone_number = userPhone;
		this.loans = new ArrayList<>();
		
		this.libraryCard = new LibraryCard();
		this.child = true;
	}
	
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public void showLoans()  {
    	for(int i = 0; i < loans.size(); i++) {
    		System.out.print("Loan");
    		// TODO fix
    	}
    }
	
	public boolean canCheckOut() {
		if(this.child) {
			// Children can only check out 5 materials at a time
			if(loans.size() >= 5) {
				return false;
			} else return true;
		} else return true; // All other users can check out unlimited items
	}

}
