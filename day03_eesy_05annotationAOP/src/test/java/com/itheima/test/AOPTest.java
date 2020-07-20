package com.itheima.test;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test AOP Configuration
 */
public class AOPTest {

    public static void main(String[] args) {
        //1. Get container
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. Get object
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3. Execute
        as.saveAccount();

    }
}
