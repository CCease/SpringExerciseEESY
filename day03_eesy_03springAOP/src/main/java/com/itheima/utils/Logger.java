package com.itheima.utils;

/**
 * A classs use to save log, provide 公用代码 here.
 */
public class Logger {

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行。(切入点方法就是业务层方法）。
     */
    public void printLog(){
        System.out.println("printLog function in Logger class executed.");
    }
}
