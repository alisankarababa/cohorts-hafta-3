package com.n11.service;

import com.n11.entity.Customer;
import com.n11.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;


@Service
public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, ICustomerRepository> implements ICustomerService{

    @Autowired
    public CustomerServiceImpl(ICustomerRepository repository) {
        super(repository);
    }

    @Override
    public List<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(char ch) {
        return super.getRepository().findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(ch);
    }

    @Override
    public List<Customer> findAllByTimeOfCreation_Month(Month month) {

        return super.getRepository().findAllByTimeOfCreation_Month(month);
    }

    @Override
    public List<Customer> findAllByBills_TotalAmountDueIsLessThanOrEqual(double limit) {

        return super.getRepository().findAllByBills_TotalAmountDueIsLessThanOrEqual(limit);
    }
}
