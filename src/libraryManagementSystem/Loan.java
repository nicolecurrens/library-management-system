package libraryManagementSystem;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Loan {
	// Loan is between one user and one material
	public LocalDate checkOutDate;
	public LocalDate dueDate;
	public boolean renewed = false;
	public User user;
	public LoanableMaterials material;
	public String loanID;
	
	public Loan(User u, LoanableMaterials m, LocalDate checkOutDate) {
		this.user = u;
		this.material = m;
		this.checkOutDate = checkOutDate;
		this.loanID = generateLoanID();
	}
	
	public boolean can_renew() {
		if(this.renewed == false) {
			// TODO then need to check if there are open requests
			return true;
		} else {
			return false;
		}
	}
	
	public abstract void calculateDueDate();
	
	public User getUser() {
		return this.user;
	}
	
	public LoanableMaterials getMaterial() {
		return this.material;
	}
	
	public void renew() {
		this.renewed = true;
	}
	
	public String generateLoanID() {
		UUID uuid = UUID.randomUUID();
        return uuid.toString();
        
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
}