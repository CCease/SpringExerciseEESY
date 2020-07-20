package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

    private int i = 1;

    public void saveAccount() {
        System.out.println("Account Saved Successfully");
        System.out.println(i);
        i++;
    }
}
