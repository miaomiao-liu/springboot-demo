package com.liuyiqing.repository;

import com.liuyiqing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by miaomiao on 18-2-25.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //jpa自定义查询语句
    //查询大于20岁的用户
    @Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
    List<User> nativeQuery(int age);

    //@Modifying 配合 @Query 注解, 可以完成数据的删除，增加，更新操作
    @Transactional
    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 and t_address = ?2",nativeQuery = true)
    void deleteQuery(String name,String address);



}
