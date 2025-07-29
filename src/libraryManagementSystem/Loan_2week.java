package libraryManagementSystem;
import java.time.LocalDate;

public class Loan_2week extends Loan {
	
	public Loan_2week(String checkOutDate, User u, LoanableMaterials l) {
		super(u, l, checkOutDate);
	}
	
	public String calculateDueDate(String checkOutDate) {
		// TODO probably this can't be a string, check out LocalDate
		
	}
	
}