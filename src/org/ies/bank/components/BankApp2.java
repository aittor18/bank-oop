package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp2 {
private final Scanner scanner;
private final BankReader bankReader;

    public BankApp2(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        Account account = bank.findAccount("ES0001");
        if (account.getIban().equals("ES0001")) {
            bank.deposit("ES0001", 500);
        }
    }
}
