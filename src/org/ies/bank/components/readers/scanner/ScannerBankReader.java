package org.ies.bank.components.readers.scanner;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class ScannerBankReader {
    private final Scanner scanner;
    private final ScannerAccountReader scannerAccountReader;

    public ScannerBankReader(Scanner scanner, ScannerAccountReader scannerAccountReader) {
        this.scanner = scanner;
        this.scannerAccountReader = scannerAccountReader;
    }

    public Bank read() {
        System.out.println("Introduce los datos del banco");
        System.out.print("Nombre del banco: ");
        String name = scanner.nextLine();
        System.out.print("¿Cuántas cuentas hay en el banco?: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Account[] accounts = new Account[size];
        for (int i = 0; i < size; i++) {
            accounts[i] = scannerAccountReader.read();
        }
        return new Bank(name, accounts);
    }
}
