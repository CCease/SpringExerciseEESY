package com.itheima.proxy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
         *      1. 基于接口的动态代理
         *          Proxy, by JDK Official
         *          newProxyInstance() in Proxy class
         *          被代理类最少实现一个功能，如果没有则不能使用。
         *
         *          newProxyInstance parameter:
         *              ClassLoader:用于加载代理对象的字节码，和被代理对象使用相同的ClassLoader.固定写法
         *              Class[]:用于让代理对象和被代理对象有相同method.固定写法
         *              InvocationHandler:用于写增强的代码，
         *                      让我门写如何代理，一般都是一个该interface的实现类，通常情况下都是匿名内部类，Optional
         *                      谁用谁写。
         *
         */

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法（包起来了）
                     * @param proxy 代理对象的引用
                     * @param method 执行的method
                     * @param args method的parameter
                     * @return same return with method return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强代码
                        Object returnValue = null;
                        //1. get method parameter
                        Float money = (Float) args[0];
                        //2. See method is sell or not.
                        if ("sellProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f); //Simulate 经销商get20%
                        }
                        return returnValue;
                    }
                });
        proxyProducer.sellProduct(10000F);
    }
}
