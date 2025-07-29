package libraryManagementSystem;

import java.time.LocalDate;

public class Loan_3week extends Loan {
	
	public Loan_3week(User u, LoanableMaterials m, LocalDate checkOutDate) {
		super(u, m, checkOutDate);
		calculateDueDate();
	}
	
	public void calculateDueDate() {
		this.dueDate = this.checkOutDate.plusWeeks(3);
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
}