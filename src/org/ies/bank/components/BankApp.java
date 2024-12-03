package org.ies.bank.components;

import java.util.Scanner;

public class BankApp {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en la cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Salir");
            System.out.print("Introduce la opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

            }
        } while (option != 6);


    }
}
