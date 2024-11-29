package org.ies.bank.components;

import org.ies.bank.model.Account;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;

    public AccountReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Account read() {
        System.out.println("Introduce los datos de la cuenta");
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        System.out.print("Saldo: ");
        double balance = scanner.nextDouble();
        System.out.print("Ahora, ¿cuántos clientes hay?: ");

    }
}
