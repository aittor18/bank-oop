package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Bank bank;
    private final Scanner scanner;

    public BankApp(Bank bank, Scanner scanner) {
        this.bank = bank;
        this.scanner = scanner;
    }

    public void run() {
        int option;
        do {
            System.out.println("Elige una opción");
            System.out.println("1. Mostrar cuentas");
            System.out.println("2. Mostrar datos de cuenta");
            System.out.println("3. Mostrar cuentas de un cliente");
            System.out.println("4. Ingresar dinero");
            System.out.println("5. Sacar dinero");
            System.out.println("6. Salir");
            System.out.print("Introduce la opción que quieras: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    bank.showAccounts();
                    break;
                case 2:
                    System.out.println("Introduce el IBAN: ");
                    String iban = scanner.nextLine();
                    Account account = bank.findAccount(iban);
                    if (!account.getIban().equals(iban)) {
                        account.showInfo();
                    } else {
                        System.out.println("Cuenta no encontrada");
                    }
                    break;
                case 3:

            }
        } while (option != 6);
    }
}
