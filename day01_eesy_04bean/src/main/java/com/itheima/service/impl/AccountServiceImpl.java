package com.itheima.service.impl;

import com.itheima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl class is created.");
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount method is executed.");
    }
}
