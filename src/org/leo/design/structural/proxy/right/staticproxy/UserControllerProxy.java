package org.leo.design.structural.proxy.right.staticproxy;

import org.leo.design.structural.proxy.base.MetricsCollector;
import org.leo.design.structural.proxy.base.RequestInfo;
import org.leo.design.structural.proxy.right.base.IUserController;
import org.leo.design.structural.proxy.right.base.UserController;

/**
 * 模块名称: CRM
 * 模块描述: 代理类 实现接口 伪代码
 *
 * 参照基于接口而非实现编程的设计思想，将原始类对象替换为代理类对象的时候，为了让代码改动尽量少，
 * 在刚刚的代理模式的代码实现中，代理类和原始类需要实现相同的接口。但是，如果原始类并没有定义接口，
 * 并且原始类代码并不是我们开发维护的（比如它来自一个第三方的类库），我们也没办法直接修改原始类，
 * 给它重新定义一个接口。在这种情况下，我们该如何实现代理模式呢？
 *
 * 对于这种外部类的扩展，我们一般都是采用继承的方式
 * @author xiaochuang.mao
 * @date 2020/5/22 13:31
 */
public class UserControllerProxy implements IUserController {

    /**依赖注入下UserController*/
    private UserController userController;
    /** 这里去依赖注入下MetricsController*/
    private MetricsCollector metricsCollector;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public Object login(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        //委托
        userController.login(telephone,password);
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        return new Object();
    }

    @Override
    public Object register(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        //委托
        userController.register(telephone,password);
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        return new Object();
    }
}
class Test{
    public static void main(String[] args) {
        //UserControllerProxy使用举例
        //因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        //将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        UserControllerProxy userControllerProxy = new UserControllerProxy(new UserController());
    }
}
