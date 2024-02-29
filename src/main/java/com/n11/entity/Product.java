package com.n11.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseEntity{

    private Long id;
    private Long companyId;
    private Double price;
}
