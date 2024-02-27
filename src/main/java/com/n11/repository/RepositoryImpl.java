package com.n11.repository;

import com.n11.entity.BaseEntity;
import com.n11.sequence_generator.ISequenceGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class RepositoryImpl<E extends BaseEntity, S extends ISequenceGenerator> implements IRepository<E, Long>{

    private final Map<Long, E> entityMap;
    private final S sequenceGenerator;

    @Override
    public E save(E entity) {

        if(entity.getId() == null) {
            entity.setId(sequenceGenerator.generateId());
        }

        entityMap.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public Optional<E> findById(Long id) {
        E entity= entityMap.get(id);
        return  Optional.ofNullable(entity);
    }

    @Override
    public List<E> findAll() {
        return entityMap.values().stream().toList();
    }

    @Override
    public void deleteById(Long id) {
        entityMap.remove(id);
    }
}