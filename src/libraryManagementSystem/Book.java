package libraryManagementSystem;

public class Book extends LoanableMaterials {
	public boolean bestseller = false;
	
	public Book(String title, double value) {
		super(title, value);
		
	}
	
	public void updateBestsellerStatus(boolean status) {
		this.bestseller = status;
	}
	
	public boolean getBestsellerStatus() {
		return this.bestseller;
	}
}