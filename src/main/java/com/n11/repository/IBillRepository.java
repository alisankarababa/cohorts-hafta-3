package com.n11.repository;

import com.n11.entity.Bill;

import java.time.Month;
import java.util.List;

public interface IBillRepository extends IRepository<Bill, Long> {

    List<Bill> findAllByTotalAmountDueIsGreaterThanEqual(double limit);
    List<Bill> findAllByCustomerIdAndTotalAmountDueIsLessThanEqual(long customerId, double limit);
    List<Bill> findAllByCustomer_CreationTime_Month(Month month);
}
