package com.itheima.cglib;

import com.itheima.proxy.IProducer;

/**
 * One Producer
 */
public class Producer implements IProducer {

    public void sellProduct(Float money){
        System.out.println("Sell item successfully: get "+money);
    }

    public void afterService(Float money){}
}
