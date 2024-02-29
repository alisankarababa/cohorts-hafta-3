package com.n11.service;

import com.n11.entity.Product;
import com.n11.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseEntityServiceImpl<Product, IProductRepository> implements IProductService {

    public ProductServiceImpl(IProductRepository repository) {
        super(repository);
    }
}
