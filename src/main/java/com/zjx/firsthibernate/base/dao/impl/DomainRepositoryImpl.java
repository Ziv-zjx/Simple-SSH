package com.zjx.firsthibernate.base.dao.impl;

import com.zjx.firsthibernate.base.dao.IDomainRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public class DomainRepositoryImpl<T,PK extends Serializable> implements IDomainRepository<T,PK> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class clazz;

    /*
    * openSession() 与 getCurrentSession() 有何不同和关联呢？
         在 SessionFactory 启动的时候， Hibernate 会根据配置创建相应的 CurrentSessionContext ，在 getCurrentSession() 被调用的时候，
         实际被执行的方法是 CurrentSessionContext.currentSession() 。在 currentSession() 执行时，如果当前 Session 为空，
         currentSession 会调用 SessionFactory 的 openSession 。所以 getCurrentSession() 对于 Java EE 来说是更好的获取 Session 的方法。

    * * 采用getCurrentSession()创建的session会绑定到当前线程中，
      * 而采用openSession() 创建的session则不会
        * 采用getCurrentSession()创建的session在commit或rollback时会自动关闭，
        * 而采用openSession()创建的session必须手动关闭
        使用getCurrentSession()需要在hibernate.xml文件中加入事务的相关配置，也要在配置文件中开启上下文的session配置
    *
    * */
    /**
     * 创建新的Session
     * @return
     */
    private Session getOpenSession() {
        return this.sessionFactory.openSession();
    }

    /**
     * 获取当前上下文的session，有直接获取，没有的话就创建一个，绑定在当前线程中,有的话就不创建,getCurrentSession的使用是依赖事务的。需要在配置文件中开启事务
     * @return
     */
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public DomainRepositoryImpl(){
        // 获得泛型化超类(DomainRepositoryImpl<People>)
        if (this.getClass().getName().equals(DomainRepositoryImpl.class.getName())) {
            clazz = this.getClass();
        } else {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            // 获得class<User>
            clazz = (Class) type.getActualTypeArguments()[0];
        }
    }

    @Override
    public T load(PK id) {
        return (T)getCurrentSession().load(this.clazz,id);
    }

    @Override
    public T get(PK id) {
        return (T)getCurrentSession().get(this.clazz,id);
    }

    @Override
    public void persist(T entity) {

        getCurrentSession().persist(entity);
    }

    @Override
    public PK save(T entity) {
        return (PK)getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(PK id) {
        T entity = get(id);
        getCurrentSession().delete(entity);
/*        Session session = getOpenSession();
        T entity = (T)session.get(this.clazz,id);
        session.delete(entity);
        session.close();*/
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public void evict(T entity) {
        getCurrentSession().evict(entity);
    }

    @Override
    public void clear() {
        getCurrentSession().clear();
    }

}
