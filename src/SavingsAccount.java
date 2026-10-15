public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double minimumBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }

        if (balance - amount < minimumBalance) {
            System.out.printf("Savings Rejection: Cannot withdraw $%.2f. Balance would fall below minimum of $%.2f.%n",
                    amount, minimumBalance);
        } else {
            balance -= amount;
            System.out.printf("Savings Withdrawal: $%.2f. New balance: $%.2f%n", amount, balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Savings End of Month: Interest applied at %.2f%%. New balance: $%.2f%n",
                (interestRate * 100), balance);
    }
}