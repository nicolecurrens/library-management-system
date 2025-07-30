package libraryManagementSystem;

public abstract class Materials {
	
	public String title;
	public boolean available = true;
	
	public abstract void printTitle();
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}