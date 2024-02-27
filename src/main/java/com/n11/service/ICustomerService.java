package com.n11.service;

import com.n11.entity.Customer;

import java.time.Month;
import java.util.List;

public interface ICustomerService extends IBaseEntityService<Customer>{

    List<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(char ch);
    List<Customer> findAllByTimeOfCreation_Month(Month month);
}
