package com.n11.service;


import com.n11.entity.BaseEntity;
import com.n11.repository.IRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class BaseEntityServiceImpl<E extends BaseEntity, R extends IRepository<E, Long>> implements IBaseEntityService<E>{

    private final R repository;

    @Override
    public E save(E e) {

        LocalDateTime timeNow = LocalDateTime.now();

        if(e.getId() == null) {
            e.setTimeOfCreation(timeNow);
        }

        e.setTimeOfUpdate(timeNow);

        return repository.save(e);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(long id) {

        Optional<E> optionalE = repository.findById(id);
        if(optionalE.isEmpty()) {
            throw new RuntimeException("not found");
            //TODO create a dedicated exception class: NotFoundException
        }

        return optionalE.get();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}