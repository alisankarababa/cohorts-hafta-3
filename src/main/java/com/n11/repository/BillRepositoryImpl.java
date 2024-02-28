package com.n11.repository;

import com.n11.entity.Bill;
import com.n11.sequence_generator.BillIdSequenceGenerator;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BillRepositoryImpl extends RepositoryImpl<Bill, BillIdSequenceGenerator> implements IBillRepository {

    public BillRepositoryImpl(Map<Long, Bill> entityMap, BillIdSequenceGenerator sequenceGenerator) {
        super(entityMap, sequenceGenerator);
    }
}
