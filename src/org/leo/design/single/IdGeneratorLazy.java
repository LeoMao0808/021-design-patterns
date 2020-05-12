package org.leo.design.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 懒汉式 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public class IdGeneratorLazy {

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorLazy instance;
    //构造方法私有化  private修饰
    private IdGeneratorLazy(){}
    //开放公共获取单例对象的接口 增加sync锁
    public static synchronized IdGeneratorLazy getInstance(){
        if (instance == null ){
            instance = new IdGeneratorLazy();
        }
        return instance;
    }
    //id自增
    public long getId(){
        return id.incrementAndGet();
    }
}
