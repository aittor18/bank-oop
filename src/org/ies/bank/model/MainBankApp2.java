package org.ies.bank.model;

import org.ies.bank.components.readers.scanner.ScannerAccountReader;
import org.ies.bank.components.readers.scanner.BankApp2;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class MainBankApp2 {
    public static void main(String args[] ) {
        Scanner scanner = new Scanner(System.in);
        ScannerCustomerReader scannerCustomerReader = new ScannerCustomerReader(scanner);
        ScannerAccountReader scannerAccountReader = new ScannerAccountReader(scanner, scannerCustomerReader);
        ScannerBankReader scannerBankReader = new ScannerBankReader(scanner, scannerAccountReader);
        BankApp2 bankApp2 = new BankApp2(scannerBankReader);

        bankApp2.run();
    }
}
