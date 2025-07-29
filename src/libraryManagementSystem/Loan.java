package libraryManagementSystem;

public abstract class Loan {
	// Loan is between one user and one material
	public String checkOutDate;
	public String dueDate;
//	public String dueDate;
//	public String checkInDate;
	public boolean renewed = false;
	public User user;
	public LoanableMaterials material;
	
	public Loan(User u, LoanableMaterials m, String checkOutDate) {
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
	
	public abstract String calculateDueDate(String checkOutDate);
	
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