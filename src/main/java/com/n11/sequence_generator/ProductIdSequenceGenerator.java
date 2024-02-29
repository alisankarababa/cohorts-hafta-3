package com.n11.sequence_generator;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductIdSequenceGenerator implements ISequenceGenerator{

    private final AtomicLong idGenerator;

    public ProductIdSequenceGenerator() {
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public Long generateId() {
        return idGenerator.getAndIncrement();
    }
}
