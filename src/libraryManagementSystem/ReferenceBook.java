package libraryManagementSystem;

public class ReferenceBook extends UnloanableMaterials {

    public ReferenceBook(String title) {
        super(title);
    }

    @Override
    public String getType() {
        return "Reference Book";
    }

	@Override
	public void printTitle() {
		System.out.println(this.title);
		
	}
    
}