package com.n11.entity;

import com.n11.enums.eSector;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company extends BaseEntity {

    private Long id;
    private String name;
    private eSector sector;
}
