import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        // Create a List<Account> containing a mix of SavingsAccount and CurrentAccount objects
        List<Account> accounts = new ArrayList<>();

        // Initialize with starting balances, minimums, limits, and rates/fees
        accounts.add(new SavingsAccount("SA001", 1000.0, 500.0, 0.05)); // 5% interest
        accounts.add(new CurrentAccount("CA001", 500.0, 200.0, 15.0));   // $200 overdraft limit, $15 fee

        System.out.println("--- Polymorphic Loop: Calling withdraw() and endOfMonth() ---");

        // Loop through the list calling withdraw() and endOfMonth() through the Account reference only
        for (Account acc : accounts) {
            System.out.println("\nProcessing Account: " + acc.accountNumber);

            // Demonstrate withdrawal behavior (using a generic amount to show polymorphism)
            acc.withdraw(100.0);

            // Call endOfMonth
            acc.endOfMonth();
        }

        System.out.println("\n--- Edge Case Demonstrations ---");

        // Edge Case 1: SavingsAccount withdrawal correctly rejected
        System.out.println("\nEdge Case 1: SavingsAccount withdrawal rejection");
        Account savings = accounts.get(0); // SA001
        // Current balance is ~945.00. Try to withdraw 600, which leaves 345, below the 500 minimum.
        savings.withdraw(600.0);

        // Edge Case 2: CurrentAccount going into overdraft within its limit
        System.out.println("\nEdge Case 2: CurrentAccount going into overdraft within limit");
        Account current = accounts.get(1); // CA001
        // Current balance after fee is roughly 385.00. Overdraft limit is 200.
        // Withdraw 500 leaves -115, which is within the -200 limit.
        current.withdraw(500.0);
    }
}
