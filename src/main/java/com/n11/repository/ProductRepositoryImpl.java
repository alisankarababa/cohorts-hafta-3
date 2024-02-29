package com.n11.repository;

import com.n11.entity.Product;
import com.n11.sequence_generator.ProductIdSequenceGenerator;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepositoryImpl extends RepositoryImpl<Product, ProductIdSequenceGenerator> implements IProductRepository {

    public ProductRepositoryImpl(Map<Long, Product> entityMap, ProductIdSequenceGenerator sequenceGenerator) {
        super(entityMap, sequenceGenerator);
    }
}
