package com.itheima.cglib;

import com.itheima.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Simualate a consumer
 */
public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理：
         *  字节码随用随创建，随用随加载
         *  不修改源码的基础上对方法增强
         *
         *      2. 基于子类的动态代理 - 子类可以不实现任何接口
         *          Enhancer, by cglib 库
         *          create() in Enhancer class
         *          被代理类不能是最终类。（final）不能有子类的类
         *
         *          create parameter:
         *              Class:用于加载代理对象的字节码，指定被代理对象的字节码。
         *              Callback:用于写增强的代码，
         *                      让我门写如何代理，一般都是一个该interface的实现类，通常情况下都是匿名内部类，Optional，
         *                      谁用谁写。
         *                      一般写的都是该接口的子接口实现类，MethodInterceptor
         *
         */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 被代理对象的任何方法都会经过该方法
             * @param o -> proxy
             * @param method
             * @param objects -> args
             *       above 3 same with 基于接口的动态代理
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强代码
                Object returnValue = null;
                //1. get method parameter
                Float money = (Float) objects[0];
                //2. See method is sell or not.
                if ("sellProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f); //Simulate 经销商get20%
                }
                return returnValue;
            }
        });

        cglibProducer.sellProduct(10000f);
    }
}
