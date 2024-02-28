package com.n11;

import com.n11.entity.Bill;
import com.n11.entity.Customer;
import com.n11.service.IBillService;
import com.n11.service.ICustomerService;
import com.n11.util.Mean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@SpringBootApplication
public class CohortsHafta3Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(CohortsHafta3Application.class, args);

        String lineSeparator = "\n\n------------------------------------------------------------------------------------------------\n\n";
        ICustomerService customerService = applicationContext.getBean(ICustomerService.class);
        IBillService billService = applicationContext.getBean(IBillService.class);


        customerService.save(new Customer("Ali", "Veli", "aliveli@email.com", LocalDate.of(1994, 10, 11)));
        customerService.save(new Customer("Ahmet", "Yılmaz", "ahmetyilmaz@email.com", LocalDate.of(1990, 5, 25)));
        customerService.save(new Customer("Ayşe", "Kaya", "aysekaya@email.com", LocalDate.of(1985, 3, 17)));
        customerService.save(new Customer("Mehmet", "Cemal", "mehmetcemal@email.com", LocalDate.of(1988, 7, 8)));
        customerService.save(new Customer("Ceren", "Demir", "cerendemir@email.com", LocalDate.of(1992, 12, 3)));


        System.out.println("All customers:\n");
        customerService.findAll().forEach( customer -> System.out.println("-" + customer + "\n"));
        System.out.println(lineSeparator);

        System.out.println("Customers registered in June:\n");
        customerService.findAllByTimeOfCreation_Month(Month.JUNE).forEach(customer -> System.out.println("-" + customer + "\n"));
        System.out.println(lineSeparator);


        System.out.println("Customers whose firstname or lastname contains the letter \"c\"\n:");
        customerService.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase('c').forEach( customer -> System.out.println("-" + customer + "\n"));
        System.out.println(lineSeparator);


        System.out.println("All bills:\n");
        billService.findAll().forEach( bill -> System.out.println("-" + bill + "\n"));
        System.out.println(lineSeparator);



        List<Bill> billsHavingTotalAmountDueGreaterThanOrEqualTo1500 = billService.findAllByTotalAmountDueIsGreaterThanEqual(1500);

        System.out.println("All bills having totalAmountDue greater than or equal to 1500:\n");
        billsHavingTotalAmountDueGreaterThanOrEqualTo1500.forEach(bill -> System.out.println("-" + bill + "\n"));
        System.out.println(lineSeparator);

        System.out.println("Mean totalAmountDue of bills having totalAmountDue greater than or equal to 1500:\n");
        System.out.printf("%.2f\n", Mean.calculate(billsHavingTotalAmountDueGreaterThanOrEqualTo1500));
        System.out.println(lineSeparator);

        System.out.println("Name of customers who has bills having totalAmountDue less than or equal to 500:\n");
        System.out.println(
                customerService.findAllByBills_TotalAmountDueIsLessThanOrEqual(500).stream()
                        .map(Customer::getFirstName)
                        .toList()
        );
        System.out.println(lineSeparator);

    }

}
