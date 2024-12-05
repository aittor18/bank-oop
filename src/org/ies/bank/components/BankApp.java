package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final BankReader bankReader;
    private final Scanner scanner;

    public BankApp(BankReader bankReader, Scanner scanner) {
        this.bankReader = bankReader;
        this.scanner = scanner;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        CustomerReader customerReader = new CustomerReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        BankApp bankApp = new BankApp(bankReader, scanner);

        bankApp.run();
    }
}
