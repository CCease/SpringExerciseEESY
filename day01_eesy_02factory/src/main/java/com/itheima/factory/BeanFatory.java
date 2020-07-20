package com.itheima.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 一个创建Bean对象的工厂
 *
 * Bean         : 可重用组件
 * JavaBean     : 用Java编写的可重用组件
 *
 * javaben=/=实体类
 * javabean>实体类
 *
 * Can use to create service and dao.
 *
 * 1. Use one configuration file to configure our service and dao.
 *
 *    Configuration: Key=Value
 *
 * 2. Read the configuration file to 反射创建 object.
 *
 * Configuration : 1.xml 2.properties
 *
 *
 */
public class BeanFatory {
    //Create a Properties object
    private static Properties props;

    //Create a map to save the object we want to create.
    //We cal them comtainer.
    private static Map<String,Object> beans;

    //Step 1
    //Use static code to assign value to properties object.
    static {
        try {
            //Instantiate Object
            props = new Properties();

            //Get properties file stream
            //InputStream in = new FileInputStream(""); Dont use this, cannot use in web, and not flexible.
            InputStream in = BeanFatory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            //Instantiate the container.
            beans = new HashMap<String,Object>();
            //Get all key from the configuration file.
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //Get every key.
                String key = keys.nextElement().toString();
                //Get valur from key
                String beanPath = props.getProperty(key);
                //反射创建对象。
                Object value = Class.forName(beanPath).newInstance();
                //Save key and value into container.
                beans.put(key,value);

            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("Initialize Properties Fail.");
        }
    }

/*    *//* OLD WAY
     * Step 2:
     * Get Bean base on bean name.
     * @param beanName
     * @return bean
     *//*
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            //bean = Class.forName(beanPath).newInstance();
         WHY:   The line above will create a new instance everytime.
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/

    /*
    Get object base on beanName.
    @param beanName
    @return
     */

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
