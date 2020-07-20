package com.itheima.service;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**&
     * Simulate saivng of account
     */
    void saveAccount();

    /**
     * Simulate update of Account
     */
    void updateAccount(int i);

    /**
     * Simulate delete of Account
     */
    int deleteAccount();

    //Why this 3, because to simuilate 3 circumstances.
    //1. no return no parameter.
    //2. no return 1 parameter
    //3. 1 return 0 parameter
}
