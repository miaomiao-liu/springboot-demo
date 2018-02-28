package com.liuyiqing.repository.repositoryImpl;

import com.liuyiqing.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 如果不想暴露那么多的方法，可以自己订制自己的Repository，还可以在自己的Repository里面添加自己使用的公共方法,
 * 当然更灵活的是自己写一个实现类，来实现自己需要的方法:
 * 1.写一个与接口同名的类，加上后缀为Impl,
 * 2.在接口中加入自己需要的方法,
 * 3.在实现类中，去实现这个方法就好了
 * Created by miaomiao on 18-2-26.
 */
public class UserRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    public Page<Object[]> getByCondition(User u){
        String hql = "select o.address,o.name from User o where o.name=:username";
        Query q = em.createQuery(hql);
        q.setParameter("username", u.getName());
        q.setFirstResult(0);
        q.setMaxResults(1);
        Page<Object[]> page = new PageImpl<Object[]>(q.getResultList(),new PageRequest(0,1),3);
        return page;
    }
}
