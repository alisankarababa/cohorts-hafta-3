package com.n11.service;

import com.n11.entity.Bill;
import com.n11.entity.Customer;
import com.n11.entity.Product;
import com.n11.util.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final IBillService billService;

    @Autowired
    public PurchaseService(IBillService billService) {
        this.billService = billService;
    }

    public void purchase(Customer customer, List<Product> productList) {

        List<Bill> billList = Billing.createBillsForProductsGroupedByCompanyId(customer, productList);

        billList.forEach(billService::save);
    }
}