package com.n11.repository;

import com.n11.entity.Bill;
import com.n11.entity.Customer;
import com.n11.sequence_generator.BillIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BillRepositoryImpl extends RepositoryImpl<Bill, BillIdSequenceGenerator> implements IBillRepository {

    private final ICustomerRepository customerRepository;

    @Lazy
    @Autowired
    public BillRepositoryImpl(Map<Long, Bill> entityMap, BillIdSequenceGenerator sequenceGenerator, ICustomerRepository customerRepository) {
        super(entityMap, sequenceGenerator);
        this.customerRepository = customerRepository;
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

    @Override
    public List<Bill> findAllByCustomer_CreationTime_Month(Month month) {
        return super.findAll().stream()
                .filter(bill -> {
                    Long customerId = bill.getCustomerId();
                    Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
                    if(optionalCustomer.isEmpty()) {
                        System.out.println("an error occurred!");
                        return false;
                    }

                    return optionalCustomer.get().getTimeOfCreation().getMonth() == month;
                })
                .toList();
    }
}
