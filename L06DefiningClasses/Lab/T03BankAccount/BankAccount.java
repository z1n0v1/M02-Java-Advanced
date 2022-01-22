package L06DefiningClasses.Lab.T03BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccoumtCount = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccoumtCount++;
        this.balance = 0;
    }

    int getId() {
        return this.id;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
