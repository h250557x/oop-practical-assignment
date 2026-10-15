public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit, double monthlyFee) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }

        // Allow balance to go negative, but not past the overdraft limit
        if (balance - amount < -overdraftLimit) {
            System.out.printf("Current Rejection: Cannot withdraw $%.2f. Exceeds overdraft limit of $%.2f.%n",
                    amount, overdraftLimit);
        } else {
            balance -= amount;
            System.out.printf("Current Withdrawal: $%.2f. New balance: $%.2f%n", amount, balance);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.printf("Current End of Month: Maintenance fee deducted. New balance: $%.2f%n", balance);
    }
}