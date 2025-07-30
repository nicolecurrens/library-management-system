package libraryManagementSystem;

import java.time.LocalDate;

public class CheckInManager {
    private LoanManager loanManager;

    public CheckInManager(LoanManager loanManager) {
        this.loanManager = loanManager;
    }

    /**
     * Check in a material by loan ID
     */
    public void checkInByLoanID(String loanId) {
        Loan loan = loanManager.getLoanById(loanId);
        if (loan == null) {
            System.out.println("Loan not found.");
            return;
        }

        checkIn(loan);
    }

    /**
     * Check in a material directly by the LoanableMaterials object
     */
    public void checkInByMaterial(User user, LoanableMaterials material) {
        for (Loan loan : loanManager.getLoansForUser(user)) {
            if (loan.getMaterial().equals(material)) {
                checkIn(loan);
                return;
            }
        }

        System.out.println("No active loan found for this material and user.");
    }

    private void checkIn(Loan loan) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(loan.getDueDate())) {
            System.out.println("Material is overdue. Due: " + loan.getDueDate());
        } else {
            System.out.println("Material returned on time.");
        }

        // Remove the loan
        loanManager.removeLoan(loan.getLoanID());
        System.out.println("Check-in successful for loan ID: " + loan.getLoanID());
    }
