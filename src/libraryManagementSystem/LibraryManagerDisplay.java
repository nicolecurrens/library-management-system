package libraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LibraryManagerDisplay {
	// This class handles the console output
	Scanner input = new Scanner(System.in); // TODO Ideally we'd close this scanner at the end of main to prevent memory leaks
	Hashtable<Integer, User> userSelection = new Hashtable<>();
	Hashtable<Integer, String> mainMenu = new Hashtable<>();
	Hashtable<Integer, Materials> materials = new Hashtable<>();
	private LoanManager loanManager;
	
	LibraryManagerDisplay(User[] users, Materials[] materials, LoanManager loanManager){
		
		this.userSelection = setUpUserSelection(users);
		this.mainMenu = setUpMainMenu();
		this.materials = setUpMaterials(materials);
		this.loanManager = loanManager;

	}
	
	private Hashtable<Integer, String> setUpMainMenu() {
		
		Hashtable<Integer, String> ht = new Hashtable<>();
		
		ht.put(0, "See current loans");
		ht.put(1, "Check out materials");
		ht.put(2, "Check in materials");
		ht.put(3, "Pay fines");
		ht.put(4, "Exit");
		
		return ht;
		
	}
	
	private Hashtable<Integer, User> setUpUserSelection(User[] users) {
		Hashtable<Integer, User> ht = new Hashtable<>();
		for(int i = 0; i < users.length; i++) {
			User u = users[i];
			ht.put(i, u);
		}
		
		return ht;
	}
	
	private Hashtable<Integer, Materials> setUpMaterials(Materials[] materials) {
		Hashtable<Integer, Materials> ht = new Hashtable<>();
		for(int i = 0; i < materials.length; i++) {
			Materials m = materials[i];
			ht.put(i, m);
		}
		
		return ht;
	}

	public int getUserInput(){
		
		int selection;
		selection = input.nextInt();
        System.out.println("");
        return selection;
		
	}
	
	public User displayUserSelection() {
		
		System.out.println("Pick your user: ");
		for(int i = 0; i < userSelection.size(); i++) {
			User u = userSelection.get(i);
			System.out.println(i + ": " + u.name);
		}
		int user_number = getUserInput();
		System.out.println("");
		User u = userSelection.get(user_number);
		System.out.println("You have chosen " + u.name);
		return u;
		
	}
	
	public int displayMainMenu() {
		System.out.println("How can we help you today? ");
		for(int i = 0; i < mainMenu.size(); i++) {
			String option = mainMenu.get(i);
			System.out.println(i + ": " + option);
		}
		int choice = getUserInput();
		System.out.println("");
		
		return choice;
		
	}
	
	public static void displayCurrentLoans(User u) {
		u.showLoans();
	}
	
	public Materials handleCheckOut(User user) {
	    displayMaterials();
	    System.out.print("Please select which book you would like to check out: ");
	    int materialNumber = getUserInput();
	    System.out.println();
	
	    Materials m = materials.get(materialNumber);
	    if (m == null) {
	        System.out.println("Invalid selection.");
	        return null;
	    }
	    
	    System.out.print("You have chosen ");
	    m.printTitle();
	
	    if (!(m instanceof LoanableMaterials)) {
	        System.out.println("Sorry, this item cannot be checked out.");
	        return null;
	    }
	
	    if (!m.isAvailable()) {
	    	// TODO we'll need to handle requests here
	        System.out.println("Sorry, this item is not available for checkout.");
	        return null;
	    }
	
	    if (!user.canCheckOut()) {
	        System.out.println("You have reached your checkout limit.");
	        return null;
	    }
	
	    // Use LoanManager to create the loan (delegation)
	    try {
	        loanManager.createLoan(user, (LoanableMaterials) m, java.time.LocalDate.now());
	        m.setAvailable(false); // Mark as unavailable
	        System.out.println("Checkout successful!");
	        
	        // Get the most recent loan to display due date
	        java.util.List<Loan> userLoans = user.getLoans();
	        if (!userLoans.isEmpty()) {
	            Loan latestLoan = userLoans.get(userLoans.size() - 1);
	            System.out.println("Due date: " + latestLoan.getDueDate());
	        }
	        
	        return m;
	    } catch (Exception e) {
	        System.out.println("Error creating loan: " + e.getMessage());
	        return null;
	    }
	}
	
	public void displayMaterials() {
		ArrayList<Materials> unloanable = new ArrayList<>();
		
		System.out.println("Here are the materials we have at the library: ");
		System.out.println("Materials available for check out: ");
		for(int i = 0; i < materials.size(); i++) {
			// TODO this is super inefficient, is there a better way
			Materials m = materials.get(i);
			if (m instanceof LoanableMaterials && m.isAvailable()) {
				System.out.print(i + ": ");
				m.printTitle();
			} else if (!(m instanceof LoanableMaterials)) {
				unloanable.add(m);
			}
		}
		
		System.out.println();
		
		// Now print un-loanable materials
		System.out.println("These materials are in the library, but not available for check out: ");
		for(int i = 0; i < unloanable.size(); i++) {
			Materials m = unloanable.get(i);
			System.out.println(m.toString());
		}
	}
	
	public Object handleCheckIn(User user) {
		System.out.println("Which book would you like to check in? ");
		List<Loan> loan = user.getLoans();
		for(int i = 0; i < loan.size(); i ++) {
			System.out.print(i + ": ");
			System.out.println(loan.get(i).material.title);
		}
		
		int loanNumber = getUserInput();
	    System.out.println();
	
	    Loan l = loan.get(loanNumber);
	    if (l == null) {
	        System.out.println("Invalid selection.");
	        return null;
	    }
	    
	    // Figure out due date
	    LocalDate returnDate = LocalDate.now();
	    LocalDate dueDate = l.getDueDate();

	    // Check if it's overdue
	    if (l.isOverdue(returnDate, dueDate)) {
	        System.out.println("This item is overdue. You will be charged a fine.");
	        System.out.println("Please pay your fine by returning to the main menu.");
	        // TODO: Add fine object
	    }

	    // Mark material as available again
	    l.getMaterial().setAvailable(true);

	    // Remove the loan
	    user.removeLoan(l);
	    loanManager.removeLoan(l.loanID);

	    System.out.println("Check-in successful!");
	    return l;
	}

	
	
	 public void displayFines(User user) {
        List<Fine> unpaidFines = user.getUnpaidFines();

        if (unpaidFines.isEmpty()) {
            System.out.println("You have no unpaid fines.");
            return;
        }

        System.out.println("Your unpaid fines:");
        for (int i = 0; i < unpaidFines.size(); i++) {
            System.out.println(i + ": " + unpaidFines.get(i));
        }

        System.out.println("Enter the number of the fine to pay (or -1 to skip):");
        int fineChoice = getUserInput();

        if (fineChoice >= 0 && fineChoice < unpaidFines.size()) {
            unpaidFines.get(fineChoice).pay();
            System.out.println("Fine paid successfully.");
        } else {
            System.out.println("No fines paid.");
        }
    }
	
	public void directToSubMenu(int choice, User currentUser) {
		if(choice == 0) {
			displayCurrentLoans(currentUser); // TODO add renew loan here?
		} else if(choice == 1) {
			handleCheckOut(currentUser);
		} else if(choice == 2) {
			handleCheckIn(currentUser);
		} else if(choice == 3) {
			displayFines(currentUser);
		} // TODO should probably add something to see requests too
	}
	
}
