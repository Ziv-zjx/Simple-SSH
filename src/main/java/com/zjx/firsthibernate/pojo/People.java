package com.zjx.firsthibernate.pojo;

import lombok.Data;

import javax.persistence.*;

/*
*
 hibernate中@Entity和@Table的区别：
@Entity说明这个class是实体类，并且使用默认的orm规则，即class名即数据库表中表名，class字段名即表中的字段名
如果想改变这种默认的orm规则，就要使用@Table来改变class名与数据库中表名的映射规则，@Column来改变class中字段名与db中表的字段名的映射规则

* @Entity注释指名这是一个实体Bean，@Table注释指定了Entity所要映射带数据库表，其中@Table.name()用来指定映射表的表名。
如果缺省@Table注释，系统默认采用类名作为映射表的表名。实体Bean的每个实例代表数据表中的一行数据，行中的一列对应实例中的一个属性。

@Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
2）unique：是否唯一；
3）nullable：是否允许为空；
4）length：对于字符型列，length属性指定列的最大字符长度；
5）insertable：是否允许插入；
6）updatetable：是否允许更新；
7）columnDefinition：定义建表时创建此列的DDL；
8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字。
@Id注释指定表的主键，它可以有多种生成方式：
* */
@Data
@Entity(name = "T_PEOPLE")
//@Table(name = "T_PEOPLE")
public class People {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created")
    private Long created = System.currentTimeMillis();

    @Column(name = "username",nullable=false)
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;
}