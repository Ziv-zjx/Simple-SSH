package com.zjx.firsthibernate.base.service;

import java.io.Serializable;

public interface IDomainService<T,PK extends Serializable> {

    T load(PK id);

    T get(PK id);

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    /**
     * session.flush()的作用就是将session的缓存中的数据与数据库同步，最好在事务提交之后使用，否则事务处理数据的时候，出现脏数据问题
     */
    void flush();

    void evict(T entity);
    /**
     * session.clear()的作用就是清除session中的缓存数据（不管缓存与数据库的同步）。
     */
    void clear();
}
