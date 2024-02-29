package com.n11.repository;

import com.n11.entity.Bill;
import com.n11.entity.Company;
import com.n11.sequence_generator.CompanyIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

@Repository
public class CompanyRepositoryImpl extends RepositoryImpl<Company, CompanyIdSequenceGenerator> implements ICompanyRepository {

    private final IBillRepository billRepository;

    @Autowired
    public CompanyRepositoryImpl(Map<Long, Company> entityMap, CompanyIdSequenceGenerator sequenceGenerator, IBillRepository billRepository) {
        super(entityMap, sequenceGenerator);
        this.billRepository = billRepository;
    }

    @Override
    public List<Company> findAllByBills_MonthAndTotalAmountDueAverageLessThanOrEqual(Month month, double limit) {

        return super.findAll().stream()
                .filter(company -> {

                    List<Bill> billList = billRepository.findAllByCompanyIdAndMonth(company.getId(), month);
                    OptionalDouble optionalAverage = billList.stream()
                            .mapToDouble(Bill::getTotalAmountDue)
                            .average();

                    double average = optionalAverage.isEmpty() ? 0 : optionalAverage.getAsDouble();

                    return average <= limit;
                })
                .toList();

    }
}
