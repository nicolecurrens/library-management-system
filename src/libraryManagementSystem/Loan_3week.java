package libraryManagementSystem;

public class Loan_3week extends Loan {
	
	public Loan_3week(String checkOutDate, User u, LoanableMaterials l) {
		super(u, l, checkOutDate);
	}

	@Override
	public String calculateDueDate(String checkOutDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}