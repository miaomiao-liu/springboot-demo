package com.liuyiqing.domain;

import com.liuyiqing.base.Base;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by miaomiao on 18-2-25.
 */
@Entity
@Table(name = "t_user")
//在实体类上使用@NamedQuery,在实现的DAO的Repository接口里面定义一个同名的方法,Spring会先找是否有同名的NamedQuery，如果有，那么就不会按照接口定义的方法来解析。
@NamedQuery(name = "User.findByAge",query = "select o from User o where o.age >= ?1")
public class User extends Base implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
