package com.n11.service;

import com.n11.entity.Bill;
import com.n11.repository.IBillRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class BillServiceImpl extends BaseEntityServiceImpl<Bill, IBillRepository> implements IBillService{

    public BillServiceImpl(IBillRepository repository) {
        super(repository);
    }

    public List<Bill> findAllByTotalAmountDueIsGreaterThanEqual(double limit) {
        return super.getRepository().findAllByTotalAmountDueIsGreaterThanEqual(limit);
    }

    @Override
    public List<Bill> findAllByCustomer_CreationTime_Month(Month month) {
        return super.getRepository().findAllByCustomer_CreationTime_Month(month);
    }
}
