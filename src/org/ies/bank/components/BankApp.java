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

        do {
            option = chooseOption();

            loopMenu(option);
        } while (option != 9);
    }

    private void loopMenu(int option) {
        switch (option) {
            case 1:
                Bank bank = bankReader.read();
                bank.showAccounts();
                break;
            case 2:
                bank = bankReader.read();
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
                bank = bankReader.read();
                System.out.println("Introduce el NIF: ");
                String nif = scanner.nextLine();
                bank.showAccountsNif(nif);
                break;
            case 4:
                bank = bankReader.read();
                System.out.print("Introduce un IBAN: ");
                iban = scanner.nextLine();
                System.out.print("Cuánto dinero vas a ingresar?: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                bank.deposit(iban, amount);
                break;
            case 5:
                bank = bankReader.read();
                System.out.print("Introduce un IBAN: ");
                iban = scanner.nextLine();
                System.out.print("Cuánto dinero vas a retirar?: ");
                double amount1 = scanner.nextDouble();
                scanner.nextLine();

                bank.deposit(iban, -amount1);
                break;
            case 6:
                bank = bankReader.read();
                System.out.println("Introduce tu NIF: ");
                nif = scanner.nextLine();

                bank.countAccounts(nif);
                break;
            case 7:
                bank = bankReader.read();
                System.out.println("Introduce tu IBAN: ");
                iban = scanner.nextLine();

                bank.findClientAccount(iban);
                break;
            case 8:
                bank = bankReader.read();
                System.out.print("Introduce tu IBAN: ");
                iban = scanner.nextLine();

                System.out.print("Introduce la cantidad de dinero a transferir: ");
                amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Introduce el IBAN del receptor de la transferencia: ");
                String iban2 = scanner.nextLine();

                bank.transfer(iban, iban2, amount);
                break;
            case 9:
                System.out.println("Saliendo, buenos días :)");
                break;
        }
    }

    private int chooseOption() {
        int option;
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
        return option;
    }
}