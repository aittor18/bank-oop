package org.ies.bank.components;

import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp2 {
    private final ScannerBankReader scannerBankReader;

    public BankApp2(ScannerBankReader scannerBankReader) {
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        Bank bank = scannerBankReader.read();

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

        bank.showInfo("ES0001");
        bank.showInfo("ES0002");


    }
}
