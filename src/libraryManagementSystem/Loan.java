package libraryManagementSystem;

public abstract class Loan {
	public String checkOutDate;
	public String dueDate;
	public String checkInDate;
	public boolean renewed;
	
	abstract boolean can_renew();
	
}