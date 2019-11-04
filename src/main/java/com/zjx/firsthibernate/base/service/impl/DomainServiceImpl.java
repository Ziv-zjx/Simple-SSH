package com.zjx.firsthibernate.base.service.impl;

import com.zjx.firsthibernate.base.dao.IDomainRepository;
import com.zjx.firsthibernate.base.service.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DomainServiceImpl<T,PK extends Serializable> implements IDomainService<T,PK> {

    @Autowired
    private IDomainRepository domainRepository;

    @Override
    public T load(PK id) {
        return (T)domainRepository.load(id);
    }

    @Override
    public T get(PK id) {
        return (T)domainRepository.get(id);
    }

    @Override
    public void persist(T entity) {
        domainRepository.persist(entity);
    }

    @Override
    public PK save(T entity) {
        return (PK)domainRepository.save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        domainRepository.saveOrUpdate(entity);
    }

    @Override
    public void delete(PK id) {
        domainRepository.delete(id);
    }

    @Override
    public void flush() {
        domainRepository.flush();
    }

    @Override
    public void evict(T entity) {
        domainRepository.evict(entity);
    }

    @Override
    public void clear() {
        domainRepository.clear();
    }
}
