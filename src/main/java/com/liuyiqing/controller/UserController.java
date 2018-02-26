package com.liuyiqing.controller;

import com.liuyiqing.domain.User;
import com.liuyiqing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by miaomiao on 18-2-25.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/age")
    public List<User> age(){
        return userRepository.nativeQuery(20);
    }

    @RequestMapping("/deleteWhere")
    public String deleteWhere(){
        userRepository.deleteQuery("admin","jinan");
        return "自定义SQL删除成功";
    }


}
