package libraryManagementSystem;

public class LoanableMaterials extends Materials {
	//TODO go through subclasses and see if we need to add anything here
	
	public double value;
	
	public LoanableMaterials(String title, double value) {
		this.value = value;
		this.title = title;
	}
	
	public void printTitle() {
		System.out.println(this.title);
	}
	
	public double calculate_fine(int days) {
		double fine = 0;
		for(int i = 0; i < days; i++) {
			fine += .1;
			if( fine > this.value ) {
				break;
			}
		}
		
		return fine;
		
	}
	
}