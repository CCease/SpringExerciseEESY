package com.itheima.test;

/*
Use Junit to test our configuration
!Only testing Configuration!
*/

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //1，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        List<Account> acconts = as.findAllAccount();
        for (Account account : acconts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //1，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        System.out.println(as.findAccountById(3));
        Account temp = as.findAccountById(3);
        temp.setMoney(new Float(12345));
        System.out.println(as.findAccountById(3));

    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setName("12345");
        //1，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        as.saveAccount(account);
        System.out.println(as.findAllAccount());
    }

    @Test
    public void testUpdate(){
        //1，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
    }

    @Test
    public void testDelete(){
        //1，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
    }

}
