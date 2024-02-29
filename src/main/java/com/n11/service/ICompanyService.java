package com.n11.service;

import com.n11.entity.Company;

import java.time.Month;
import java.util.List;

public interface ICompanyService extends IBaseEntityService<Company> {

    List<Company> findAllByBills_MonthAndTotalAmountDueAverageLessThanOrEqual(Month month, double limit);

}
