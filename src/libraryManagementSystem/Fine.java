package libraryManagementSystem;

import java.time.LocalDate;

public class Fine {
    private double amount;
    private boolean paid;
    private LocalDate dateIssued;
    private Loan loan;

    public Fine(double amount, Loan loan) {
        this.amount = amount;
        this.loan = loan;
        this.paid = false;
        this.dateIssued = LocalDate.now();
    }

    public double getAmount() {
        return amount;
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

    @Override
    public String toString() {
        return "Fine: $" + amount + " | Book: " + loan.material.title + " | Paid: " + paid;
    }
}

