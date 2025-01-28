package org.ies.bank.components.readers.random;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Random;

public class RandomBankReader implements BankReader {
    private final static String[] banks = {"Santander", "Kutxabank", "BBVA", "Caja Rural", "CaixaBank"};
    private final Random random;
    private final AccountReader accountReader;

    public RandomBankReader(Random random, AccountReader accountReader) {
        this.random = random;
        this.accountReader = accountReader;
    }

    @Override
    public Bank read() {
        Account[] accounts = new Account[10];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }
        return new Bank(banks[random.nextInt(banks.length)], accounts);
    }
}
