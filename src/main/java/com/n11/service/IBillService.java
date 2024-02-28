package com.n11.service;

import com.n11.entity.Bill;

import java.time.Month;
import java.util.List;

public interface IBillService extends IBaseEntityService<Bill> {

    List<Bill> findAllByTotalAmountDueIsGreaterThanEqual(double limit);
    List<Bill> findAllByCustomer_CreationTime_Month(Month month);
}
