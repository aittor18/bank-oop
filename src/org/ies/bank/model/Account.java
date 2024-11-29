package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Account {
    private String IBAN;
    private double balance;
    private Customer[] customers;

    public Account(String IBAN, double balance, Customer[] customers) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.customers = customers;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(IBAN, account.IBAN) && Objects.deepEquals(customers, account.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IBAN, balance, Arrays.hashCode(customers));
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }
}
