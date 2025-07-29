package libraryManagementSystem;

public abstract class UnloanableMaterials extends Materials {
	
    protected String title;

    public UnloanableMaterials(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
	public void printTitle() {
		System.out.println(this.title);
	}

    // Abstract method to identify type
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + title;
    }
}