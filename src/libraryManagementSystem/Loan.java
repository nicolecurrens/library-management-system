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
		
		m.setAvailable(false);
	}
	
	public boolean can_renew(RequestManager rm) {
		if(this.renewed == false) {
			if(rm.requestExists(this.material)) {
				return false;
			} else {
				return true;
			}
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
		
		LocalDate newDueDate = this.dueDate.plusWeeks(2);
		this.dueDate = newDueDate;
	}
	
	public String generateLoanID() {
		UUID uuid = UUID.randomUUID();
        return uuid.toString();
        
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
	public boolean isOverdue(LocalDate returnDate, LocalDate dueDate) {
		if (returnDate.isAfter(dueDate)) {
			return true; // it's past the due date
		} else {
			return false;
		}
	}
	
}