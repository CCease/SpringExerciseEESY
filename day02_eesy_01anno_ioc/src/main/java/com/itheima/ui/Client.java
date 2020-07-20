package com.itheima.ui;

//Simulate 表现层调用业务层

import com.itheima.dao.IAccountDao;
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
        //2. Get object base on id.

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountService as2 = (IAccountService)ac.getBean("accountService");

        as.saveAccount();
        System.out.println(as==as2);
    }
}
