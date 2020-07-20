package com.ithema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {

    public static void main(String[] args) throws Exception{

        //先在电脑里创建数据库（此处使用MySQL,自行变化）
        //创建数据库
        //mysql -uroot -ppassword
        //1. 登录Mysql
        //create database eesy:
        //2.使用数据库
        //use eesy
        //3.注入资料
        //create table account(
        //        id int primary key auto_increment,
        //name varchar(40),
        //        money float
        //)character set utf8 collate utf8_general_ci;
        //insert into account(name,money) values('aaa',1000);
        //insert into account(name,money) values('bbb',1000);
        //insert into account(name,money) values('ccc',1000);



        //以下为通过JDBC连接至数据库的基本操作。
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 此行照成编辑时的耦合。
        Class.forName("com.mysql.jdbc.Driver"); //解除了编辑时的耦合，但由于使用了String，变成了Hard Code.
                                                //解决方法，使用配置文件。

        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","1234");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
