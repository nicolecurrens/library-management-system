package libraryManagementSystem;

public abstract class Loan {
	public String checkOutDate;
	public String dueDate;
//	public String dueDate;
//	public String checkInDate;
	public boolean renewed;
	public User user;
	public LoanableMaterials material;
	
	abstract boolean can_renew();
	
}