package com.n11.util;

import com.n11.entity.Bill;
import com.n11.entity.Customer;
import com.n11.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billing {
    
    private Billing() {
        
    }

    public static List<Bill> createBillsForProductsGroupedByCompanyId(Customer customer, List<Product> productList) {
        var mapCompanyIdToProductList = Billing.getMapCompanyIdToProductList(productList);
        return Billing.createBills(customer, mapCompanyIdToProductList);
    }

    private static List<Bill> createBills(Customer customer, Map<Long, List<Product>> mapCompanyIdToProductList) {

        Long customerId = customer.getId();
        return mapCompanyIdToProductList.keySet()
                .stream()
                .map(companyId -> getBillFromCompany(mapCompanyIdToProductList.get(companyId), companyId, customerId))
                .toList();
    }

    private static Bill getBillFromCompany(List<Product> productListOfCompany, Long companyId, Long customerId) {
        Bill bill = new Bill();
        bill.setCustomerId(customerId);
        double totalAmountDue = productListOfCompany
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
        bill.setTotalAmountDue(totalAmountDue);
        bill.setCompanyId(companyId);
        return bill;
    }

    private static Map<Long, List<Product>> getMapCompanyIdToProductList(List<Product> productList) {

        Map<Long, List<Product>> mapCompanyIdToProductList = new HashMap<>();
        productList.forEach(product -> {

            Long companyId = product.getCompanyId();
            if(!mapCompanyIdToProductList.containsKey(companyId)) {
                mapCompanyIdToProductList.put(companyId, new ArrayList<>());
            }

            mapCompanyIdToProductList.get(companyId).add(product);
        });

        return mapCompanyIdToProductList;
    }
}
