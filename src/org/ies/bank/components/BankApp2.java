package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp2 {
    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        Account account = bank.findAccount("ES0001");

        if (account != null) {
            account.deposit(500);
        } else {
            System.out.println("La cuenta no existe");
        }

        account = bank.findAccount("ES0002");
        if (account != null) {
            account.deposit(-30);
        } else {
            System.out.println("La cuenta no existe");
        }

        bank.showAccounts();


    }
}
