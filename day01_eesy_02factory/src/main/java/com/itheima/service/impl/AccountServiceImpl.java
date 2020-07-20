package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFatory;
import com.itheima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    //ORIGINAL
    //private IAccountDao accountDao = new AccountDaoImpl();
    //Can change to below.
    private IAccountDao accountDao = (IAccountDao) BeanFatory.getBean("accountDao");

    //Simulate Save Account
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
