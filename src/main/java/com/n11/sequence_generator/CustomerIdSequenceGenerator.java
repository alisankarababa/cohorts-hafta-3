package com.n11.sequence_generator;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomerIdSequenceGenerator implements ISequenceGenerator{

    private final AtomicLong idGenerator;

    public CustomerIdSequenceGenerator() {

        idGenerator = new AtomicLong(1);
    }

    public Long generateId() {

        return idGenerator.getAndIncrement();
    }

}
