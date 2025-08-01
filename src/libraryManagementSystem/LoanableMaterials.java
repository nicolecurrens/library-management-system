package libraryManagementSystem;

public class LoanableMaterials extends Materials {
	//TODO go through subclasses and see if we need to add anything here
	
	public double value;
	
	public LoanableMaterials(String title, double value) {
		this.value = value;
		this.title = title;
	}
	
	public void printTitle() {
		System.out.print(this.title);
		if (this instanceof Book) {
			Book b = (Book) this;
			if (b.bestseller) {
				System.out.print( " (Bestseller!) ");
			}
		}
		System.out.println();
	}
	
	public double calculate_fine(long days) {
		double fine = 0;
		for(int i = 0; i < days; i++) {
			fine += .1;
			if( fine > this.value ) {
				break;
			}
		}

		fine = Math.round(fine * 100.0) / 100.0;

		return fine;
		
	}
	
}