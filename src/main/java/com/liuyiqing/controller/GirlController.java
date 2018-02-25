package com.liuyiqing.controller;

import com.liuyiqing.GirlRepository;
import com.liuyiqing.domain.Girl;
import com.liuyiqing.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by miaomiao on 18-2-25.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @RequestMapping(value = "/girls",method = RequestMethod.GET)
    public List<Girl> girlList(){
        System.out.println(girlRepository.findAll());
        return girlRepository.findAll();
    }


    /**
     * 添加一个女生
     */
    @PostMapping("/girls")
    public Girl girlAdd(@RequestParam("name") String name,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);

    }


    //查询一个女生
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);
    }


    //删除
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
