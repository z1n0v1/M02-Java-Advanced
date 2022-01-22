package L06DefiningClasses.Lab.T03BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Create": {
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.printf("Account ID%d created%n", account.getId());
                    break;
                }
                case "Deposit": {
                    int id = Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);
                    if(!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                    break;
                }
                case "SetInterest": {
                    double interest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                }
                case "GetInterest": {
                    int id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);
                    if (!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
}
