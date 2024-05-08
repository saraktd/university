package com.insert.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {

    protected R repository;

    public E insert(E entity) {
        return repository.save(entity);
    }

    public void update(E entity) {
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public E findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public List<E> findByExample(E entity) {
        return repository.findAll(Example.of(entity));
    }
}
