package org.leo.design.creational.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 双重检测优化版 (唯一自增id)
 * @author: leo.mao
 * @createDate: 2020/5/12
 */
public class IdGeneratorDoubleCheckBetter {
    /**
     * 网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，
     * 并且赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
     * 要解决这个问题，我们需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才行。实际上，
     * 只有很低版本的 Java 才会有这个问题。我们现在用的高版本的 Java 已经在 JDK 内部实现中解决了这个问题
     * （解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序）。
     * 这里英文没看到相关文档我们还是加上去volatile
     */

    private AtomicLong id = new AtomicLong(0);
    private volatile static IdGeneratorDoubleCheckBetter instance;

    /**
     * 构造方法私有化  private修饰
     */
    private IdGeneratorDoubleCheckBetter(){}

    /**
     * 开放公共获取单例对象的接口
     * @return IdGeneratorDoubleCheckBetter
     */
    public static IdGeneratorDoubleCheckBetter getInstance(){
        //优化点：使用局部变量接收volatile修饰的静态变量 减少对instance访问
        //这里优化点是小细节，看评论区一个老哥说的spring源码 如 ReactiveAdapterRegistry。
        //JDK 源码 如 AbstractQueuedSynchronizer。  基本都是这样写的，我只查看了spring的源码确实
        //是这样的，附上介绍为啥要这样写 参考链接：
        // https://www.javacodemonk.com/threadsafe-singleton-design-pattern-java-806ad7e6
        IdGeneratorDoubleCheckBetter localVar = instance;
        if (localVar == null ){
            //此处为类级别的锁
            synchronized (IdGeneratorDoubleCheckBetter.class){
                if (localVar == null){
                    localVar = new IdGeneratorDoubleCheckBetter();
                    instance = localVar;
                }
            }
        }
        return localVar;
    }

    /**
     * id自增
     */
    public long getId(){
        return id.incrementAndGet();
    }
}
