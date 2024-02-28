package com.n11.config;

import com.n11.entity.Bill;
import com.n11.entity.Customer;
import com.n11.sequence_generator.BillIdSequenceGenerator;
import com.n11.sequence_generator.CustomerIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class DbConfig {

    private final CustomerIdSequenceGenerator customerIdSequenceGenerator;
    private final BillIdSequenceGenerator billIdSequenceGenerator;

    private final Random random;

    @Autowired
    public DbConfig(CustomerIdSequenceGenerator customerIdSequenceGenerator, BillIdSequenceGenerator billIdSequenceGenerator) {
        this.customerIdSequenceGenerator = customerIdSequenceGenerator;
        this.billIdSequenceGenerator = billIdSequenceGenerator;
        this.random = new Random();
    }

    @Bean
    public Map<Long, Customer> customerMap() {

        Map<Long, Customer> customerMap = new HashMap<>();

        Customer customer1 = new Customer("Ahmet", "Yılmaz", "ahmetyilmaz@email.com", LocalDate.of(1994, 10, 11));
        customer1.setId(customerIdSequenceGenerator.generateId());
        customer1.setTimeOfCreation(LocalDateTime.of(2020, 2, 11, 1, 23, 32, 3300));
        customer1.setTimeOfUpdate(LocalDateTime.of(2021, 1, 1, 12, 30, 45, 5500));
        customerMap.put(customer1.getId(), customer1);

        Customer customer2 = new Customer("Mehmet", "Kaya", "mehmetkaya@email.com", LocalDate.of(1988, 5, 25));
        customer2.setId(customerIdSequenceGenerator.generateId());
        customer2.setTimeOfCreation(LocalDateTime.of(2020, 3, 11, 2, 30, 15, 9900));
        customer2.setTimeOfUpdate(LocalDateTime.of(2021, 2, 15, 9, 45, 10, 1200));
        customerMap.put(customer2.getId(), customer2);

        Customer customer3 = new Customer("Mustafa", "Demir", "mustafademir@email.com", LocalDate.of(1990, 12, 3));
        customer3.setId(customerIdSequenceGenerator.generateId());
        customer3.setTimeOfCreation(LocalDateTime.of(2020, 4, 11, 4, 10, 20, 7700));
        customer3.setTimeOfUpdate(LocalDateTime.of(2021, 3, 20, 18, 20, 30, 4300));
        customerMap.put(customer3.getId(), customer3);

        Customer customer4 = new Customer("Ayşe", "Çelik", "aysecelik@email.com", LocalDate.of(1985, 8, 17));
        customer4.setId(customerIdSequenceGenerator.generateId());
        customer4.setTimeOfCreation(LocalDateTime.of(2020, 5, 11, 5, 40, 55, 2100));
        customer4.setTimeOfUpdate(LocalDateTime.of(2021, 4, 5, 3, 10, 5, 8900));
        customerMap.put(customer4.getId(), customer4);

        Customer customer5 = new Customer("Fatma", "Şahin", "fatmasahin@email.com", LocalDate.of(1992, 4, 6));
        customer5.setId(customerIdSequenceGenerator.generateId());
        customer5.setTimeOfCreation(LocalDateTime.of(2020, 6, 12, 8, 20, 45, 4000));
        customer5.setTimeOfUpdate(LocalDateTime.of(2021, 5, 10, 15, 55, 30, 6500));
        customerMap.put(customer5.getId(), customer5);

        Customer customer6 = new Customer("Cemil", "Yıldız", "cemilyildiz@email.com", LocalDate.of(1989, 11, 30));
        customer6.setId(customerIdSequenceGenerator.generateId());
        customer6.setTimeOfCreation(LocalDateTime.of(2020, 7, 11, 10, 15, 10, 8800));
        customer6.setTimeOfUpdate(LocalDateTime.of(2021, 6, 25, 7, 20, 15, 3300));
        customerMap.put(customer6.getId(), customer6);

        Customer customer7 = new Customer("Ali", "Aydın", "aliaydin@email.com", LocalDate.of(1996, 2, 14));
        customer7.setId(customerIdSequenceGenerator.generateId());
        customer7.setTimeOfCreation(LocalDateTime.of(2020, 8, 11, 12, 45, 30, 1500));
        customer7.setTimeOfUpdate(LocalDateTime.of(2021, 7, 8, 20, 40, 55, 7600));
        customerMap.put(customer7.getId(), customer7);

        Customer customer8 = new Customer("Hasan", "Ceyhan", "hasanceyhan@email.com", LocalDate.of(1987, 7, 22));
        customer8.setId(customerIdSequenceGenerator.generateId());
        customer8.setTimeOfCreation(LocalDateTime.of(2020, 9, 11, 15, 10, 5, 9900));
        customer8.setTimeOfUpdate(LocalDateTime.of(2021, 8, 15, 12, 10, 20, 4400));
        customerMap.put(customer8.getId(), customer8);

        Customer customer9 = new Customer("Hüseyin", "Öztürk", "huseyinozturk@email.com", LocalDate.of(1993, 9, 8));
        customer9.setId(customerIdSequenceGenerator.generateId());
        customer9.setTimeOfCreation(LocalDateTime.of(2020, 6, 8, 18, 30, 25, 5500));
        customer9.setTimeOfUpdate(LocalDateTime.of(2021, 9, 30, 9, 30, 45, 6700));
        customerMap.put(customer9.getId(), customer9);

        Customer customer10 = new Customer("Osman", "Koç", "osmankoc@email.com", LocalDate.of(1991, 6, 19));
        customer10.setId(customerIdSequenceGenerator.generateId());
        customer10.setTimeOfCreation(LocalDateTime.of(2020, 6, 2, 21, 20, 50, 8900));
        customer10.setTimeOfUpdate(LocalDateTime.of(2021, 10, 20, 17, 15, 10, 8800));
        customerMap.put(customer10.getId(), customer10);

        return customerMap;
    }

    @Bean
    public Map<Long, Bill> billMap(Map<Long, Customer> customerMap) {

        Map<Long, Bill> billMap = new HashMap<>();

        customerMap.values().forEach(customer -> {

            int randomVal = random.nextInt(1, 4);

            for(int i = 0; i < randomVal; ++i) {
                Bill randomBill = randomBill(customer);
                billMap.put(randomBill.getId(), randomBill);
            }
        });

        return billMap;
    }

    private Bill randomBill(Customer customer) {

        double min = 100;
        double max = 10000;

        Bill bill = new Bill();
        bill.setId(billIdSequenceGenerator.generateId());
        bill.setCustomerId(customer.getId());
        LocalDateTime randomLocalDateTime = randomLocalDateTime();

        bill.setTotalAmountDue(random.nextDouble(max - min) + min);
        bill.setTimeOfCreation(randomLocalDateTime);
        bill.setTimeOfUpdate(randomLocalDateTime);

        return bill;
    }

    private LocalDateTime randomLocalDateTime() {

        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Europe/Istanbul");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);

        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 0, 0, 0, 0);
        LocalDateTime end = LocalDateTime.now();

        long randomEpochSecond = random.nextLong(start.toEpochSecond(zoneOffSet), end.toEpochSecond(zoneOffSet));

        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, zoneOffSet);
    }

}
