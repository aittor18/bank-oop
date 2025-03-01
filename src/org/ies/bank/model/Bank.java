package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showAccounts() {
        for (var account : accounts) {
            System.out.println("Nombre: " + account.getIban() + " Saldo: " + account.getBalance() + " NIF: " + account.getCustomer().getNIF());
        }
    }

    public void showInfo(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    public void deposit(String iban, double amount) {
        var account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public Account findAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void showIban(String iban) {
        Account account = findAccount(iban);
        if (account != null) {
            account.showInfo();
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void showAccountsNif(String nif) {
        boolean found = false;
        for (var account : accounts) {

            if (account.getCustomer().getNIF().equals(nif)) {

                System.out.print(account);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No hay cuentas para el NIF: " + nif);
        }
    }

    public int countAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {

            if (account.getCustomer().getNIF().equals(nif)) {
                count++;

            }

        }

        return count;

    }

    // Dado un IBAN, devuelve los datos del cliente al que pertenece la cuenta. Si no existe la cuenta, devuelve null

    public Customer findAccountIban(String iban) {
        Account account = findAccount(iban);

        if (account != null) {
            return account.getCustomer();
        } else {
            return null;
        }
    }

    public Account findClientAccount(String iban) {
        for (Account account : accounts) {

            if (account.getCustomer().equals(iban)) {

                return account;

            }

        }

        return null;
    }

    public void transfer(String iban, String iban2, double amount) {

        Account account = findAccount(iban);
        Account account2 = findAccount(iban2);

        if (account != null && account2 != null) {

            if (account.getBalance() >= amount) {

                account.deposit(-amount);
                account2.deposit(+amount);

            } else {
                System.out.println("No hay suficiente dinero");
            }

        } else {
            System.out.println("Una de las 2 cuentas no existe");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
