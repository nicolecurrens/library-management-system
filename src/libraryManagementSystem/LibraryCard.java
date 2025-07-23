package libraryManagementSystem;
import java.util.UUID;

public class LibraryCard {
	
	public String libraryCardID;
	
	public LibraryCard() {
		
		libraryCardID = generateLibraryCard();
		
	}
	
	public String generateLibraryCard() {
		
		UUID uuid = UUID.randomUUID();

        return uuid.toString();
        
	}

}
