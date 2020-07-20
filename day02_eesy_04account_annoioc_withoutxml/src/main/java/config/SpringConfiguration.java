package config;

/*
    配置类，和bean.xml是一样的

    @Configuration:指定当前类是一个配置类
    EXTRA : When configuration class use as a parameter for
            AnnotationConfigApplicationContext, this annotation can be ignore,

    @ConponentScan:用于通过注解指定SPring在创建容器时要扫描的包
        value = basePackages :指定SPring在创建容器时要扫描的包
                use this anno = configure ady in spring
                <context:component-scan base-package="com.itheima"></context:component-scan>
============================
    @Bean : 把当前方法的返回值当成对象存入容器中
        name : 指定bean的ID，default = 当前方法的名称

    当使用注解配置方法时，如果有参数，spring会去容器中查找对象。逻辑和AUTOWIRED一样
    ！！！就算再这里得@ComponentScan 中加入 JdbcConfig 得包，但是spring
    ！！！并不认为JdbcConfig是配置类 因此不会扫描里面的注解
    也可以在将两个配置类都当成参数传入
    eg:ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class,JdbcConfiguration.class);

    @Import : 导入其他的配置类
        value:指定其他配置类的.class
                有@import的配置都是主配置类，导入的都是子配置类


    @PropertiesSource:指定properties文件的位置
        value:指定文件的名称和路径
            classpath 表示位于类路径下

    替代了如下xml
    <!-- !!!! WHY PROTOTYPE IMPORTANT !!!! -->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
        <!--inject database-->
        <constructor-arg name="ds" ref="dataSource"></constructor-arg>
    </bean>

    <!--configure database-->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <!--Information needed to connect to databse.-->
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/eesy?useSSL=false&amp;serverTimezone=UTC"></property>
        <property name="user" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>


*/

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//@Configuration
@ComponentScan(basePackages = "com.itheima") //This is String Array, can{"","com.itheima"}
@Import({JdbcConfig.class})
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfiguration {

}
