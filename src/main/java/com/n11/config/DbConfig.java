package com.n11.config;

import com.n11.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DbConfig {

    @Bean
    public Map<Long, Customer> customerMap() {

        return new HashMap<>();
    }

}
