package com.itheima.ui;

//Simulate 表现层调用业务层

import com.itheima.factory.BeanFatory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {

        //ORIGINAL
        //IAccountService as = new AccountServiceImpl();
        //Can change to as follows

        //Although uses factory pattern, multiple objects are created, still not good.
        //Expected output, only use one instance of object.
        for (int i =  0; i<5;i++){
            IAccountService as = (IAccountService) BeanFatory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
