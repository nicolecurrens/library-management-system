package libraryManagementSystem;

public abstract class Loan_2week extends Loan {
	
	public Loan_2week(String checkOutDate, User u, LoanableMaterials l) {
		this.checkOutDate = checkOutDate;
		this.user = u;
		this.material = l;
		
		
	}
	
	public String calculateDueDate(String checkOutDate) {
		// TODO probably this can't be a string, check out LocalDate
	}
	
}