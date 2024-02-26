package com.n11.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {

    private LocalDateTime timeOfCreation;
    private LocalDateTime timeOfUpdate;

    public abstract Long getId();

}