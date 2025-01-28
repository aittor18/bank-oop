package org.ies.bank.components.readers.random;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Account;

import java.util.Random;

public class RandomAccountReader implements AccountReader {
    private final Random random;
    private final CustomerReader customerReader;

    public RandomAccountReader(Random random, CustomerReader customerReader) {
        this.random = random;
        this.customerReader = customerReader;
    }

    @Override
    public Account read() {
        return new Account("ES" + random.nextLong(90000000), random.nextLong(3000000), customerReader.read());
    }
}
