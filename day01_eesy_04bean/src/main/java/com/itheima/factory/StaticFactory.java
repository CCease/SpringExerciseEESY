package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;


/*
模拟一个工厂类（存在于jar包之中）我们无法修改constructor
 */

public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
