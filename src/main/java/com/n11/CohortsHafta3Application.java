package com.n11;

import com.n11.entity.Customer;
import com.n11.service.ICustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.logging.Logger;

@SpringBootApplication
public class CohortsHafta3Application {
    private static final Logger logger = Logger.getLogger(CohortsHafta3Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(CohortsHafta3Application.class, args);

        ApplicationContext applicationContext = SpringApplication.run(CohortsHafta3Application.class, args);

        ICustomerService customerService = applicationContext.getBean(ICustomerService.class);


        customerService.save(new Customer("Ali", "Veli", "aliveli@email.com", LocalDate.of(1994, 10, 11)));
        customerService.save(new Customer("Ahmet", "Yılmaz", "ahmetyilmaz@email.com", LocalDate.of(1990, 5, 25)));
        customerService.save(new Customer("Ayşe", "Kaya", "aysekaya@email.com", LocalDate.of(1985, 3, 17)));
        customerService.save(new Customer("Mehmet", "Cemal", "mehmetcemal@email.com", LocalDate.of(1988, 7, 8)));
        customerService.save(new Customer("Ceren", "Demir", "cerendemir@email.com", LocalDate.of(1992, 12, 3)));


        logger.info("All customers:\n");
        customerService.findAll().forEach( customer -> logger.info("-" + customer + "\n"));
    }

}
