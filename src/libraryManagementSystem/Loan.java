package libraryManagementSystem;

import java.time.LocalDate;

public abstract class Loan {
	// Loan is between one user and one material
	public LocalDate checkOutDate;
	public LocalDate dueDate;
	public boolean renewed = false;
	public User user;
	public LoanableMaterials material;
	
	public Loan(User u, LoanableMaterials m, LocalDate checkOutDate) {
		this.user = u;
		this.material = m;
		this.checkOutDate = checkOutDate;
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
	
	public abstract LocalDate getDueDate();
	
	public User getUser() {
		return this.user;
	}
	
	public LoanableMaterials getMaterial() {
		return this.material;
	}
	
	public void renew() {
		this.renewed = true;
	}
	
}