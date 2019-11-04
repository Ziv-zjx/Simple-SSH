package com.zjx.firsthibernate.base.dao;


import java.io.Serializable;

public interface IDomainRepository<T,PK extends Serializable>{
    /**
     * 获取对象，对象被使用的时候采取获取，如果对象不存在时，会抛出异常
     * @param id
     * @return
     */
    T load(PK id);

    /**
     * 获取对象，直接获取，不管该对象有没有被使用
     * @param id
     * @return
     */
    T get(PK id);


    /**
     * persist()方法会将实体对象添加到持久化上下文中，如此被保存的实体后续改变会被记录。
     * 如果在提交事务或者会话flush()，对象的属性被重新赋值，那么这个变化也会被保存到数据库中。
     * 该方法只能在事务中使用，否则数据不会进库
     * persist 保存一个对象到持久化，当无事务时，不执行sql语句，不提交对象到数据库中，有事务时与save方法相同
     * @param entity
     */
    void persist(T entity);

    /**
     * 保存对象，并返回主键
     * @param entity
     * @return
     */
    PK save(T entity);

    /**
     * 保存或者是修改对象
     * @param entity
     */
    void saveOrUpdate(T entity);

    /**
     * 删除指定对象,数据库中的数据也被删除
     * @param id
     */
    void delete(PK id);

    /**
     * session.flush()的作用就是将session的缓存中的数据与数据库同步，最好在事务提交之后使用，否则事务处理数据的时候，出现脏数据问题
     * 刷新一级缓存区的内容,使之与数据库数据保持同步。
     */
    void flush();

    /**
     * 清楚指定对象
     * @param entity
     */
    void evict(T entity);
    /**
     * session.clear()的作用就是清除session中的缓存数据（不管缓存与数据库的同步）。
     * 将一级缓存中的所有持久化对象清除,释放其占用的内存资源
     */
    void clear();
}
