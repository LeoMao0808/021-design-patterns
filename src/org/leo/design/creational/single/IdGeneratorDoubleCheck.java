package org.leo.design.creational.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 双重检测 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public class IdGeneratorDoubleCheck {
    /**
     * 网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，
     * 并且赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
     * 要解决这个问题，我们需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才行。实际上，
     * 只有很低版本的 Java 才会有这个问题。我们现在用的高版本的 Java 已经在 JDK 内部实现中解决了这个问题
     * （解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序）。
     */

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorDoubleCheck instance;
    //构造方法私有化  private修饰
    private IdGeneratorDoubleCheck(){}
    //开放公共获取单例对象的接口
    public static IdGeneratorDoubleCheck getInstance(){
        if (instance == null ){
            //此处为类级别的锁
            synchronized (IdGeneratorDoubleCheck.class){
                if (instance == null){
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }

    //id自增
    public long getId(){
        return id.incrementAndGet();
    }
}
