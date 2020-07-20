package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {

    private String example1;
    private int example2;
    private Date example3;

    public void setExample1(String example1) {
        this.example1 = example1;
    }

    public void setExample2(int example2) {
        this.example2 = example2;
    }

    public void setExample3(Date example3) {
        this.example3 = example3;
    }

    //Shortcut Key ALT+INSERT

    public void saveAccount() {
        System.out.println("service 中的 saveAccount method is executed.");

    }
}
