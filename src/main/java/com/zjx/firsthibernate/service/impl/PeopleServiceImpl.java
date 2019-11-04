package com.zjx.firsthibernate.service.impl;

import com.zjx.firsthibernate.base.service.impl.DomainServiceImpl;
import com.zjx.firsthibernate.dao.IPeopleDao;
import com.zjx.firsthibernate.pojo.People;
import com.zjx.firsthibernate.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PeopleServiceImpl extends DomainServiceImpl<People,Long> implements IPeopleService{


    @Autowired
    private IPeopleDao personRepository;
    @Override
    public Long savePerson() {

        People person = new People();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        Long id =  personRepository.save(person);
        persistPerson();

        return  id;
    }
    @Override
    public void persistPerson() {

        People person = new People();
        person.setUsername("zjx");

        person.setPhone("18155924573");
        person.setAddress("安徽合肥市");
        person.setRemark("this is demo");
       // personRepository.saveOrUpdate(person);
        personRepository.persist(person);
        //personRepository.flush();
    }

    @Override
    public People updateAddress(Long id) {
        People people = this.get(id);

        people.setAddress("测试地址"+new Date());

        return people;
    }

}
