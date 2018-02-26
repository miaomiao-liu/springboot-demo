package com.liuyiqing.repository;

import com.liuyiqing.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by miaomiao on 18-2-25.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询
    List<Girl> findByAge(Integer age);


}
