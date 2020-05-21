package org.leo.design.creational.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 静态内部类 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public class IdGeneratorStaticInnerClass {
    /**
     * SingletonHolder 是一个静态内部类，当外部类 IdGeneratorStaticInnerClass 被加载的时候，
     * 并不会创建 SingletonHolder 实例对象。只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，
     * 这个时候才会创建 instance。instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
     * 所以，这种实现方法既保证了线程安全，又能做到延迟加载。
     */

    private AtomicLong id = new AtomicLong(0);
    //构造方法私有化  private修饰
    private IdGeneratorStaticInnerClass(){}

    private static class  SingletonHolder{
         private  static final IdGeneratorStaticInnerClass instance = new IdGeneratorStaticInnerClass();
    }

    //开放公共获取单例对象的接口
    public static IdGeneratorStaticInnerClass getInstance(){
        return SingletonHolder.instance;
    }
    //id自增
    public long getId(){
        return id.incrementAndGet();
    }
}
