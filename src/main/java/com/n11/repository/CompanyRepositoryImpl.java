package com.n11.repository;

import com.n11.entity.Company;
import com.n11.sequence_generator.CompanyIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CompanyRepositoryImpl extends RepositoryImpl<Company, CompanyIdSequenceGenerator> implements ICompanyRepository {

    @Autowired
    public CompanyRepositoryImpl(Map<Long, Company> entityMap, CompanyIdSequenceGenerator sequenceGenerator) {
        super(entityMap, sequenceGenerator);
    }
}
