package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/*
Use Junit to test our configuration
!Only testing Configuration!
*/

/*
    Spring 整合Junit的配置 (Junit的main中并不会去扫描注解，因此利用@Autowired to give ac value cannot work)
        1. 导入Spring整合Junit的jar（spring-test)
        2. 使用Junit的提供的annotation将Junit的main换成springtest的main(@RunWith)
        3. 告知spring，spring 的 ioc 创建时基于XML还是注解，并注明位置。
            @ContextConfiguration
                Locations: XML place + classpath
                classes: annotation place

        Minumum requirement of Junit in Spring 5.X must be 4.12 +

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
     private IAccountService as;

    @Test
    public void testFindAll(){

        //3. 执行方法
        List<Account> acconts = as.findAllAccount();
        for (Account account : acconts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
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
        //3. 执行方法
        as.saveAccount(account);
        System.out.println(as.findAllAccount());
    }

    @Test
    public void testUpdate(){

        //3. 执行方法
    }

    @Test
    public void testDelete(){

        //3. 执行方法
    }

}
