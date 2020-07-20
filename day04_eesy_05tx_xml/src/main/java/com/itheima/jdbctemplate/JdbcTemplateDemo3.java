package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBCtemplate 最基本用法
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1. get container
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.get object
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3. execute
        //1. save
        jt.update("INSERT  into account(name,money)values(?,?)","eee",3333f);
        //2. update
        jt.update("update account set name=?,money=? where id=?","test",4565,2);
        //3. delete
        jt.update("delete from account where id =?",3);
        //4. find all
        //List<Account> accounts = jt.query("select * from account where money > ?",new AccountRowMapper(),1000);
        List<Account> accounts = jt.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(),1000);
        for (Account account : accounts){
            System.out.println(account);
        }
        //5. find one
        List<Account> accounts2 = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(),1);
        System.out.println(accounts2.isEmpty()?"no id found":accounts2.get(0));
        //6. 查询返回一行一列（使用聚合函数，但不加Group By子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);

    }
}
//定义account的封装类
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后由Spring把每个Account加入集合中。
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
