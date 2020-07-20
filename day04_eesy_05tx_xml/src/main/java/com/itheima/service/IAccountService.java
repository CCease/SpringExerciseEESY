package com.itheima.service;

import com.itheima.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    Account findAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);
}
