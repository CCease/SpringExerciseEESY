package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * A classs use to save log, provide 公用代码 here.
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知 beforePrintLog function in Logger class executed.");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知 afterReturningPrintLog function in Logger class executed.");
    }
    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知 afterThrowingPrintLog function in Logger class executed.");
    }
    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知 afterPrintLog function in Logger class executed.");
    }

    /**
     * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     *
     * 对比了动态代理中的环绕通知代码，里没有明确的切入点方法调用，这里没有。
     *
     * 解决：
     * Spring给我们提供的接口, ProceedingJoinPoint。该接口有一个方法proceed（），
     * 此方法就相当于明确调用切入点方法。该接口可以作为环绕通知的方法参数，在层序执行时
     * ，spring会为我们提供该接口的实现类供我们调用。
     *
     *
     * Spring中的环绕通知：
     *      Spring提供的一种可以在代码中手动控制增强方法何时执行的模式。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;

        try {
            Object[] args = pjp.getArgs();//Get Args(parameter of method)
            System.out.println("Before.");
            rtValue = pjp.proceed(args);//明确调用业务层方法(切入点方法）
            System.out.println("AfterReturn.");
            return rtValue;
        }catch (Throwable t){
            System.out.println("AfterThrowing");
            throw  new RuntimeException(t);
        }finally {
            System.out.println("After.");

        }


    }
}
