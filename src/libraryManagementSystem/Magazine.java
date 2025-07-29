package libraryManagementSystem;

public class Magazine extends UnloanableMaterials {
    private String issue;

    public Magazine(String title, String issue) {
        super(title);
        this.issue = issue;
    }
    
    @Override
    public String getType() {
        return "Magazine";
    }

	@Override
	public String toString() {
		return this.getType() + ": " + this.title + ", issue: " + this.issue;
		
	}
}
