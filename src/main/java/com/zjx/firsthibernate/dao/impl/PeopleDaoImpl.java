package com.zjx.firsthibernate.dao.impl;

import com.zjx.firsthibernate.base.dao.impl.DomainRepositoryImpl;
import com.zjx.firsthibernate.dao.IPeopleDao;
import com.zjx.firsthibernate.pojo.People;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleDaoImpl extends DomainRepositoryImpl<People,Long> implements IPeopleDao {
}
