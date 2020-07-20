package com.itheima.ui;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    public static void main(String[] args) {


        //1. Get core container object.
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. Get object base on id.
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountService as2 = (IAccountService)ac.getBean("accountService2");
        IAccountService as3 = (IAccountService)ac.getBean("accountService3");

        as.saveAccount();
        as2.saveAccount();
        as3.saveAccount();


    }
}
