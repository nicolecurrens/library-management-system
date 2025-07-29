package libraryManagementSystem;

public class Magazine extends UnloanableMaterials {
    private String issue;

    public Magazine(String title, String issue) {
        super(title);
        this.issue = issue;
    }

    // TODO should print issue number as well
    
    @Override
    public String getType() {
        return "Magazine";
    }

	@Override
	public void printTitle() {
		System.out.println(this.title);
		
	}
}
