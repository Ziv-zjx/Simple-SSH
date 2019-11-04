package com.zjx.firsthibernate.service;

import com.zjx.firsthibernate.base.service.IDomainService;
import com.zjx.firsthibernate.pojo.People;

public interface IPeopleService extends IDomainService<People,Long> {

    Long savePerson();

    void persistPerson();

    People updateAddress(Long id);
}
