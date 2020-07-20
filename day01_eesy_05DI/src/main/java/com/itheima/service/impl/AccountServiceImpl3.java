package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.*;

public class AccountServiceImpl3 implements IAccountService {

    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    //Shortcut Key ALT+INSERT
    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(array));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(properties);
    }
}
