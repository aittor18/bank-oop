package org.ies.bank.components.readers.scanner;

import java.util.Scanner;

public class BankAppMenu {
    private final Scanner scanner;
    private final ScannerBankReader scannerBankReader;

    public BankAppMenu(Scanner scanner, ScannerBankReader scannerBankReader) {
        this.scanner = scanner;
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        int option;
        var bankData = scannerBankReader.read();
        do {
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar diner de una cuenta");
            System.out.println("6. Contar cuentas de cliente");
            System.out.println("7. Mostrar cliente de cuenta");
            System.out.println("8. Realizar transferencia");
            System.out.println("9. Salir del menú");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    bankData.showAccounts();
                    break;

                case 2:
                    System.out.print("Introduce un número de IBAN: ");
                    String iban = scanner.nextLine();
                    var account = bankData.findAccount(iban);
                    break;

                case 3:
                    bankData.showAccounts();
                    break;

                case 4:

            }
        } while (option != 9);
    }
}
