package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public String name;
	public String address;
	public String phone_number;
	public LibraryCard libraryCard;
	public int age;
	public boolean child;
	private List<Loan> loans;
	private List<Fine> fines = new ArrayList<>();
	
	public User(String userName, String userAddress, String userPhone, int userAge) {
		
		this.name = userName;
		this.address = userAddress;
		this.phone_number = userPhone;
		this.age = userAge;
		this.loans = new ArrayList<>();
		
		this.libraryCard = new LibraryCard();
	}
	
	public String getID() {
		return this.libraryCard.libraryCardID;
	}
	
	public User(String userName, String userAddress, String userPhone, boolean child) {
		// Overloaded constructor for child user
		this.name = userName;
		this.address = userAddress;
		this.phone_number = userPhone;
		this.age = 12; // Default age for child
		this.loans = new ArrayList<>();
		
		this.libraryCard = new LibraryCard();
	}
	
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public void showLoans()  {
    	for(int i = 0; i < loans.size(); i++) {
    		Loan l = loans.get(i);
    		l.material.printTitle();
    		System.out.println("due on: " + l.dueDate);
    	}
    }
    
    public List<Loan> getLoans() {
    	return this.loans;
    }
	
	public boolean canCheckOut() {
		if(this.age <= 12) {
			// Children can only check out 5 materials at a time
			if(loans.size() >= 5) {
				return false;
			} else return true;
		} else return true; // All other users can check out unlimited items
	}
	 
    public void addFine(Fine fine) {
    fines.add(fine);
    }

    public List<Fine> getUnpaidFines() {
    return fines.stream().filter(f -> !f.isPaid()).toList();
    }

}
