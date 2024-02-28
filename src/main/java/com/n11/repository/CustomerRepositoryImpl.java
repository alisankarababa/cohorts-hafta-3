package com.n11.repository;

import com.n11.entity.Customer;
import com.n11.sequence_generator.CustomerIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


@Repository
public class CustomerRepositoryImpl extends RepositoryImpl<Customer, CustomerIdSequenceGenerator> implements ICustomerRepository {

    private final IBillRepository billRepository;

    @Autowired
    public CustomerRepositoryImpl(Map<Long, Customer> entityMap, CustomerIdSequenceGenerator sequenceGenerator, IBillRepository billRepository) {
        super(entityMap, sequenceGenerator);
        this.billRepository = billRepository;
    }

    @Override
    public List<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(char ch) {

        return queryCustomers(
                customer -> customer.getFirstName()
                                    .toLowerCase()
                                    .contains(
                                        String.valueOf(ch).toLowerCase()
                                    ) ||
                            customer.getLastName()
                                    .toLowerCase()
                                    .contains(
                                        String.valueOf(ch).toLowerCase()
                                    )
        );
    }

    @Override
    public List<Customer> findAllByTimeOfCreation_Month(Month month) {

        return queryCustomers(customer -> customer.getTimeOfCreation().getMonth() == month );
    }

    @Override
    public List<Customer> findAllByBills_TotalAmountDueIsLessThanOrEqual(double limit) {

        return super.findAll().stream()
                .filter(
                    customer ->
                        !billRepository
                        .findAllByCustomerIdAndTotalAmountDueIsLessThanEqual(customer.getId(), limit)
                        .isEmpty()
                )
                .toList();
    }

    private List<Customer> queryCustomers(Predicate<Customer> predicate) {

        return super.getEntityMap().values().stream()
                .filter(predicate)
                .toList();
    }
}
