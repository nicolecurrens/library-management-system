package libraryManagementSystem;
import java.time.LocalDate;

public class Loan_2week extends Loan {
	
	public Loan_2week(User u, LoanableMaterials m, LocalDate checkOutDate) {
		super(u, m, checkOutDate);
		calculateDueDate();
	}
	
	public void calculateDueDate() {
		this.dueDate = this.checkOutDate.plusWeeks(2);
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
}