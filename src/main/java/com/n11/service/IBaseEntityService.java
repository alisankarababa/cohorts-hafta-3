package com.n11.service;

import com.n11.entity.BaseEntity;

import java.util.List;

public interface IBaseEntityService<E extends BaseEntity> {

    E save(E e);
    List<E> findAll();
    E findById(long id);
    void deleteById(long id);
}
