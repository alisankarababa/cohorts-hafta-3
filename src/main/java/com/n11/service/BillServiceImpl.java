package com.n11.service;

import com.n11.entity.Bill;
import com.n11.repository.IBillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends BaseEntityServiceImpl<Bill, IBillRepository> implements IBillService{

    public BillServiceImpl(IBillRepository repository) {
        super(repository);
    }
}
