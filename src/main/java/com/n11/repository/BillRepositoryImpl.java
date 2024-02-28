package com.n11.repository;

import com.n11.entity.Bill;
import com.n11.sequence_generator.BillIdSequenceGenerator;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BillRepositoryImpl extends RepositoryImpl<Bill, BillIdSequenceGenerator> implements IBillRepository {

    public BillRepositoryImpl(Map<Long, Bill> entityMap, BillIdSequenceGenerator sequenceGenerator) {
        super(entityMap, sequenceGenerator);
    }

    @Override
    public List<Bill> findAllByTotalAmountDueIsGreaterThanEqual(double limit) {

        return super.getEntityMap().values().stream()
                .filter(bill -> bill.getTotalAmountDue() >= limit)
                .toList();

    }

    @Override
    public List<Bill> findAllByCustomerIdAndTotalAmountDueIsLessThanEqual(long customerId, double limit) {
        return super.findAll().stream()
                .filter(bill -> bill.getCustomerId() == customerId && bill.getTotalAmountDue() <= limit)
                .toList();
    }
}
