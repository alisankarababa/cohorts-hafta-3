package com.n11.sequence_generator;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerIdSequenceGenerator {

    private CustomerIdSequenceGenerator() {
    }
    private static final AtomicLong idGenerator = new AtomicLong(1);

    public static Long generateId() {

        return idGenerator.getAndIncrement();
    }

}
