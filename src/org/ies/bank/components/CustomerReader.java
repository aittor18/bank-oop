package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader implements CustReader{
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read() {
        System.out.println("Introduce los datos del cliente");
        System.out.print("NIF: ");
        String NIF = scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellidos: ");
        String surname = scanner.nextLine();

        return new Customer (
                NIF,
                name,
                surname
        );
    }
}
