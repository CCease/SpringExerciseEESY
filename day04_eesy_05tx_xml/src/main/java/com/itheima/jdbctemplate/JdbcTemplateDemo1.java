package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBCtemplate 最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setUsername("1234");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");

        //1. create jdbc template object
        JdbcTemplate jt = new JdbcTemplate(ds);
        //2. execute
        jt.execute("INSERT INTO account(name,money)values('ccc',1000)");
    }
}
