package org.ies.bank.components;

import org.ies.bank.model.Account;
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
        int option;
        Bank bank = bankReader.read();

        do {
            System.out.println("Elige una opción");
            System.out.println("1. Mostrar cuentas");
            System.out.println("2. Mostrar datos de cuenta");
            System.out.println("3. Mostrar cuentas de un cliente");
            System.out.println("4. Ingresar dinero");
            System.out.println("5. Sacar dinero");
            System.out.println("6. Contar cuentas de un cliente");
            System.out.println("7. Mostrar cliente de cuenta");
            System.out.println("8. Realizar transferencia");
            System.out.println("9. Salir");
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
                    System.out.println("Introduce el NIF: ");
                    String nif = scanner.nextLine();
                    bank.showAccounts(nif);
                    break;

                case 4:
                    System.out.print("Introduce un IBAN: ");
                    iban = scanner.nextLine();
                    System.out.print("Cuánto dinero vas a ingresar?: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    bank.deposit(iban, amount);
                    break;

                case 5:
                    System.out.print("Introduce un IBAN: ");
                    iban = scanner.nextLine();
                    System.out.print("Cuánto dinero vas a retirar?: ");
                    double amount1 = scanner.nextDouble();
                    scanner.nextLine();

                    bank.deposit(iban2, -amount1);
                    break;

                case 6:
                    System.out.println("Introduce tu NIF: ");
                    nif = scanner.nextLine();

                    bank.countAccounts(nif);
                    break;

                case 7:
                    System.out.println("Introduce tu IBAN: ");
                    iban = scanner.nextLine();

                    bank.findClientAccount(iban);
                    break;
            }
        } while (option != 6);
    }
}
