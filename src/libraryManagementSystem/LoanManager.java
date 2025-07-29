package libraryManagementSystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class LoanManager {
    private Map<String, User> usersById;
    private Map<String, Loan> loansById;

    // TODO should this be a singleton, only one loan manager per program
    public LoanManager() {
        usersById = new HashMap<>();
        loansById = new HashMap<>();
    }

    public void addUser(User user) {
        usersById.put(user.getID(), user);
    }

    public void createLoan(User u, LoanableMaterials material, LocalDate checkOutDate) {
    	String userID = u.getID();
        
        // Add user to list if not already there
        if (usersById.get(userID) == null) {
        	usersById.put(userID, u);
        }
        
        if (checkOutDate == null) {
        	// If check out date is passed as null, the loan takes place today
        	checkOutDate = LocalDate.now();
        }
        
    	int type = determineLoanLength(material);
    	Loan loan;
    	if(type == 2) {
    		loan = new Loan_2week(u, material, checkOutDate);
    	} else {
    		// it's a 3 week loan
    		loan = new Loan_3week(u, material, checkOutDate);
    	}
        u.addLoan(loan);
        loansById.put(loan.loanID, loan);
    }
    
    public int determineLoanLength(LoanableMaterials m) {
    	if(m instanceof AV) {
    		return 2;
    	} else {
    		// If it's not AV it must be a Book
    		Book b = (Book) m; // Casting LoanableMaterials to Book
    		if(b.bestseller) {
    			return 2;
    		} else {
    			return 3;
    		}
    	}
    }

    public void removeLoan(String loanId) {
        Loan loan = loansById.remove(loanId);
        if (loan != null) {
            loan.getUser().removeLoan(loan);
        }
    }

    public List<Loan> getLoansForUser(User u) {
        User user = usersById.get(u.getID());
        return user != null ? user.getLoans() : Collections.emptyList();
    }

}