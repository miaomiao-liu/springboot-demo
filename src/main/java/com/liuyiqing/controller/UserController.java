package com.liuyiqing.controller;

import com.liuyiqing.domain.User;
import com.liuyiqing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    @RequestMapping("/cutPage")
    public List<User> cutPage(int page){
        User user = new User();
        user.setPage(page);
        user.setSord("desc");
        user.setSize(2);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction,user.getSidx());
        //创建分页的对象
        PageRequest pageRequest = new PageRequest(user.getPage()-1,user.getSize(),sort);
        return userRepository.findAll(pageRequest).getContent();
    }


    @RequestMapping("/testNamedQuery")
    public List<User> testNamedQuery(){
        return userRepository.findByAge(20);
    }

    @RequestMapping("/testQueryLike")
    public List<User> testQueryLike(){
        return userRepository.findByName("m");
    }

    @RequestMapping("/testUserRepositoryImpl")
    public Page<Object[]> testUserRepositoryImpl(){
        User user = new User();
        user.setName("miaomiao");
        user.setAddress("deyang");
        user.setAge(20);
        return userRepository.getByCondition(user);
    }
}
