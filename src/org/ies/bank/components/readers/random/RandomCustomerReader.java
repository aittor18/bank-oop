package org.ies.bank.components.readers.random;

import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Random;

public class RandomCustomerReader implements CustomerReader {
    private final Random random;

    private final static String[] name = {"Carlos", "Jesús", "Aitor", "Joaquín"};
    private final static String[] surname = {"Domínguez", "Rodriguez", "Calvo", "Gómez"};

    public RandomCustomerReader(Random random) {
        this.random = random;
    }

    @Override
    public Customer read() {
        return new Customer(
                random.nextLong(10000000) + "X",
                name[random.nextInt(name.length)],
                surname[random.nextInt(surname.length)]
        );
    }
}
