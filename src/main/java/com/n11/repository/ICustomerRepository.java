package com.n11.repository;

import com.n11.entity.Customer;

import java.time.Month;
import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, Long>{

    List<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(char ch);
    List<Customer> findAllByTimeOfCreation_Month(Month month);
}