package practicesem3.week7practice;

public class PiggyBank {
    private double savings;
    private final String id;

    // Constructor
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Insufficient balance.");
        } else if (amount > 0) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Getter for savings
    public double getSavings() {
        return savings;
    }

    // Getter for ID
    public String getId() {
        return id;
    }
}
