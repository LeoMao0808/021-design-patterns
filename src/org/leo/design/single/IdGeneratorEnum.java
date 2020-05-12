package org.leo.design.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 枚举 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public enum  IdGeneratorEnum {
    /**
     * 简单的实现方式，基于枚举类型的单例实现。
     * 这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性
     */
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    //id自增
    public long getId(){
        return id.incrementAndGet();
    }
}
