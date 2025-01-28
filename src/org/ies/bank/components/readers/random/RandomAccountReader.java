package org.ies.bank.components.readers.random;

import org.ies.bank.components.AccountReader;
import org.ies.bank.model.Account;

import java.util.Random;

public class RandomAccountReader implements AccountReader {
    private final Random random;

    public RandomAccountReader(Random random) {
        this.random = random;
    }

    @Override
    public Account read() {
        return new Account(random.nextInt(90000000), );
    }
}
