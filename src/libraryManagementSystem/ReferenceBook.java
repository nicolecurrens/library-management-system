package libraryManagementSystem;

public class ReferenceBook extends UnloanableMaterials {

    public ReferenceBook(String title) {
        super(title);
    }

    @Override
    public String getType() {
        return "Reference Book";
    }
    
}