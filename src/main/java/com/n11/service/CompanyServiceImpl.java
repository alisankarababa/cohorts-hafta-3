package com.n11.service;

import com.n11.entity.Company;
import com.n11.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class CompanyServiceImpl extends BaseEntityServiceImpl<Company, ICompanyRepository> implements ICompanyService {

    @Autowired
    public CompanyServiceImpl(ICompanyRepository repository) {
        super(repository);
    }

    @Override
    public List<Company> findAllByBills_MonthAndTotalAmountDueAverageLessThanOrEqual(Month month, double limit) {
        return super.getRepository().findAllByBills_MonthAndTotalAmountDueAverageLessThanOrEqual(month, limit);
    }
}
