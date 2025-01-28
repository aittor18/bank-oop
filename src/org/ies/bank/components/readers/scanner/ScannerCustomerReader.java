package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerCustomerReader implements CustomerReader {
    private final Scanner scanner;

    public ScannerCustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
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
