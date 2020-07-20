package com.itheima.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Test Query Runner is singleton or not
public class QueryRunnerTest {

    @Test
    public void QueryRunnerTest(){
        //Get Configuration Class
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //
        QueryRunner qr1 = ac.getBean("runner",QueryRunner.class);
        QueryRunner qr2 = ac.getBean("runner",QueryRunner.class);

        System.out.println(qr1 == qr2);
    }
}
