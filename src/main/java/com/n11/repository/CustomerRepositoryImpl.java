package com.n11.repository;

import com.n11.entity.Customer;
import com.n11.sequence_generator.CustomerIdSequenceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final Map<Long, Customer> customerMap;

    @Override
    public Customer save(Customer customer) {

        if(customer.getId() == null) {
            customer.setId(CustomerIdSequenceGenerator.generateId());
            customerMap.put(customer.getId(), customer);
        } else {
            customerMap.put(customer.getId(), customer);
        }

        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Customer customer = customerMap.get(id);
        return  Optional.ofNullable(customer);
    }

    @Override
    public List<Customer> findAll() {

        return customerMap.values().stream().toList();
    }

    @Override
    public void deleteById(Long id) {
        customerMap.remove(id);
    }

    @Override
    public List<Customer> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(char ch) {

        return queryCustomers(
                customer -> customer.getFirstName()
                                    .toLowerCase()
                                    .contains(
                                        String.valueOf(ch).toLowerCase()
                                    ) ||
                            customer.getLastName()
                                    .toLowerCase()
                                    .contains(
                                        String.valueOf(ch).toLowerCase()
                                    )
        );
    }

    @Override
    public List<Customer> findAllByTimeOfCreation_Month(Month month) {

        return queryCustomers(customer -> customer.getTimeOfCreation().getMonth() == month );
    }

    private List<Customer> queryCustomers(Predicate<Customer> predicate) {

        return customerMap.values().stream()
                .filter(predicate)
                .toList();
    }
}
