package com.n11.repository;

import com.n11.entity.Bill;

import java.util.List;

public interface IBillRepository extends IRepository<Bill, Long> {

    List<Bill> findAllByTotalAmountDueIsGreaterThanEqual(double limit);
}
