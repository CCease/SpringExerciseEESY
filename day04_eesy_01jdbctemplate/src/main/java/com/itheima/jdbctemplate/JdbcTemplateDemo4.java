package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBCtemplate 最基本用法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1. get container(从配置拿）
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.get object
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        //3. execute
        Account account = accountDao.findAccountById(2);
        System.out.println(account);

        account.setMoney(1000f);

    }
}
