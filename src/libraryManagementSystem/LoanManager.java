package libraryManagementSystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class LoanManager {
    private Map<String, User> usersById;
    private Map<String, Loan> loansById;

    public LoanManager() {
        usersById = new HashMap<>();
        loansById = new HashMap<>();
    }

    public void addUser(User user) {
        usersById.put(user.getID(), user);
    }

    public void createLoan(String userId, LoanableMaterials material, LocalDate checkOutDate) {
        User user = usersById.get(userId);
        if (user != null) {
        	int type = determineLoanLength(material);
        	Loan loan;
        	if(type == 2) {
        		loan = new Loan_2week(user, material, checkOutDate);
        	} else {
        		// it's a 3 week loan
        		loan = new Loan_3week(user, material, checkOutDate);
        	}
            user.addLoan(loan);
            // TODO what to do about loan ID
            loansById.put(loanId, loan);
        }
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