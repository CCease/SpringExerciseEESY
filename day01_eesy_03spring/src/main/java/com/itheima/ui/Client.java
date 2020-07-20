package com.itheima.ui;

//Simulate 表现层调用业务层

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /*
        Get the IOC Core of spring and ger object from it using id

        ApplicationContext most use 3 实现类。
        1. ClassPathXmlApplicationContext     : 可以加载类路径下的配置文件，配置文件不许再类路径下！
        2. FileSystemXmlApplicationContext    : 可以加载任意路径下的配置文件（必须有访问权限）
        3. AnnotationConfigApplicationContext : 读取注解创制文件。

        核心容器的俩个接口引发出的问题:

        ApplicationContext: 适合单例对象 Used Most Of The Time.
        -创建核心容器时，采用立即加载的方式
        -只要一读完配置文件马上就创建配置文件中所有对象

        BeanFactory:        适合多例对象
        -创建核心容器时，采用延迟加载的方式
        -什么时候根据ID获取对象，什么时候创建对象

        可以在对应的CLASS的CONSTRUCTOR内增加PRINT来查看上述之间的差别。

    */

    public static void main(String[] args) {
/*

        //1. Get core container object.
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new FileSystemXmlApplicationContext("path");
        //2. Get object base on id.
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();
*/

        //---------BeanFactory---------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        IAccountService as = (IAccountService)factory.getBean("accountService");
        IAccountDao adao = factory.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();
    }
}
