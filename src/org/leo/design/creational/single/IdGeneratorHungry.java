package org.leo.design.creational.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 饿汉式 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public class IdGeneratorHungry {
    private AtomicLong id = new AtomicLong(0);
    //实例化对象设置为final  设置为static类加载的时候初始化好,线程安全
    private static final IdGeneratorHungry instance = new IdGeneratorHungry();
    //构造方法私有化  private修饰
    private IdGeneratorHungry(){}
    //开放公共获取单例对象的接口
    public static IdGeneratorHungry getInstance(){
        return instance;
    }
    //id自增
    public long getId(){
        return id.incrementAndGet();
    }
}
