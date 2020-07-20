package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

//账户的业务层实现类
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("Save execute.");
    }

    public void updateAccount(int i) {
        System.out.println("Update execute.");
    }

    public int deleteAccount() {
        System.out.println("Delete execute.");
        return 0;
    }
}
