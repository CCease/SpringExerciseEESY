package com.itheima.proxy;

/**
 * 对生产厂家Producer的要求
 */
public interface IProducer {

    public void sellProduct(Float money);

    public void afterService(Float money);
}
