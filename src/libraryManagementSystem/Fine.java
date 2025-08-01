package libraryManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fine {
    private double amount;
    private boolean paid;
    private LocalDate dateIssued;
    public Loan loan;

    public Fine(Loan loan) {
        this.loan = loan;
        this.paid = false;
        this.dateIssued = LocalDate.now();
        
        this.amount = calculateAmount();
    }

    public double getAmount() {
        return calculateAmount();
    }

    public boolean isPaid() {
        return paid;
    }

    public void pay() {
        this.paid = true;
    }

    public Loan getLoan() {
        return loan;
    }
    
    public double calculateAmount() {
    	LoanableMaterials m = loan.getMaterial();
    	LocalDate dueDate = loan.dueDate;
    	LocalDate today = LocalDate.now();
    	long daysBetween = ChronoUnit.DAYS.between(dueDate, today);
    	
    	return m.calculate_fine(daysBetween);
    }

    @Override
    public String toString() {
        return "Fine: $" + amount + " | Book: " + loan.material.title + " | Paid: " + paid;
    }
}

