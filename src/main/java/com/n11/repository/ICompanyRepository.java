package com.n11.repository;

import com.n11.entity.Company;

import java.time.Month;
import java.util.List;

public interface ICompanyRepository extends IRepository<Company, Long>  {

    List<Company> findAllByBills_MonthAndTotalAmountDueAverageLessThanOrEqual(Month month, double limit);

}
