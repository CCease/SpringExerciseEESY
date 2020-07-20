package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
 *  original in xml, now we want to chagne to annotation.
 *  <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *          scope="" init-methods="" destroy-methods="">
 *      <property name="" value = ""|ref="”></propety>
 *  </bean>
 *
 * 1. Use to create object <bean>
 *
 *      @Component : 把当前类对象存入Spring容器中.
 *           value : bean id (dafault = 当前类名但首字母小写)
 *
 *      分别对应表现层，业务层和持久层。所做的事情和@Componeng一模一样
 *      @Controller
 *      @Service
 *      @Repository
 *
 *
 * 2. Use to inject <property> (no need to use set method when using injection annotation.)
 *      @Autowired : 如果容器中只有唯一一个bean对象类型和要注入的变量类型去陪，就注入成功（自动按照类型注入）
 *                  如果有两个同样类型，先过滤类型，然后利用变量名称作为ID进行查找，如果没有一样就报错。
 *
 *      @Qualifier : 按照类注入的基础之上再按照名称注入，
 *                   Can't use solo on field, but can solo use in method parameter
 *          value: for id.
 *
 *      @Resource : 直接按照bin的id注入                                            常用
 *          name: for id.
 *
 * @Autowired @Qualifier and @Resource can only use to inject other bean, cannot normal
 * etc string, int.
 * 集合类型（list map array）只能通过XML来实现
 *
 *      @Value : 注入基本类型和String
 *          value : for id. (Can use SpEL) SpEL = el expression in Spring
 *                  SpEl expression : ${expression}
 *      eg @value(value = "string")
 *          private String string
 *
 * 3. Use to change scope <scope>
 *      @Scope : change scope
 *          scope : change scope (singleton and prototype)
 *
 * 4. 和生命周期相关   <init-method and destroy-method> Understand can dy
 *      @PreDestroy : choose destruction method
 *
 *      @PostConstruct : choose the method to execute before construct
 */

@Component("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

    /*@Autowired
    @Qualifier("accountDao1")*/
    @Resource(name = "accountDao1")
    private IAccountDao accountDao2 = null;

    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
