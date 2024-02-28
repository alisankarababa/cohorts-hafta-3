package com.n11.sequence_generator;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class BillIdSequenceGenerator implements ISequenceGenerator{

    private final AtomicLong idGenerator;

    public BillIdSequenceGenerator() {
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public Long generateId() {
        return idGenerator.getAndIncrement();
    }
}
