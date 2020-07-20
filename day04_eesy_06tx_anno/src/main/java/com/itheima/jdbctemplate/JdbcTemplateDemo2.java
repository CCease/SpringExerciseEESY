package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBCtemplate 最基本用法
 */
public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        //1. get container(从配置拿）
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.get object
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3. execute
        jt.execute("INSERT INTO account(name,money)values('ccc',1000)");

    }
}
