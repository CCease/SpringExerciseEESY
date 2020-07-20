package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("Account Saved Successfully2222");
    }
}
