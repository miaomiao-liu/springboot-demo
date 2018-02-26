package com.liuyiqing.service;

import com.liuyiqing.domain.Girl;
import com.liuyiqing.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 18-2-25.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

//    @Transactional
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setName("A");
        girl1.setAge(21);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setName("B");
        girl2.setAge(21);
        girlRepository.save(girl2);
    }

}
