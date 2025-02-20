import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts;
    private TreeMap<Double, Integer> sortedAccounts;
    private Map<Integer, Double> withdrawalAmounts; // To track withdrawal amounts

    public BankingSystem() {
        accounts = new HashMap<>();
        sortedAccounts = new TreeMap<>();
        withdrawalAmounts = new HashMap<>(); // Initialize the withdrawal amounts map
    }

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        double balance = accounts.get(accountNumber);
        balance += amount;
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void withdraw(int accountNumber, double amount) {
        withdrawalAmounts.put(accountNumber, amount); // Store the withdrawal amount
    }

    public void processWithdrawals() {
        for (Map.Entry<Integer, Double> entry : withdrawalAmounts.entrySet()) {
            int accountNumber = entry.getKey();
            double amount = entry.getValue();
            double balance = accounts.get(accountNumber);
            if (balance >= amount) { // Check if balance is enough
                balance -= amount;
                accounts.put(accountNumber, balance);
                sortedAccounts.put(balance, accountNumber);
            } else {
                System.out.println("Insufficient funds in Account Number: " + accountNumber);
            }
        }
    }

    public double getBalance(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void printSortedAccounts() {
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account Number: " + entry.getValue() + " - Balance: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.createAccount(101, 5000);
        system.createAccount(102, 3000);
        system.createAccount(103, 10000);
        system.deposit(101, 1000);
        system.deposit(102, 500);
        system.withdraw(101, 2000);
        system.withdraw(102, 1000);
        system.processWithdrawals();
        system.printSortedAccounts();
    }
}
