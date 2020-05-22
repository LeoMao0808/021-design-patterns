package org.leo.design.structural.proxy.wrong;

import org.leo.design.structural.proxy.base.MetricsCollector;
import org.leo.design.structural.proxy.base.RequestInfo;

/**
 * 模块名称: CRM
 * 模块描述: 用户控层伪代码
 *
 * 这种写法的问题所在：
 * 1.接口计数器框架代码耦合业务代码，以后替换这个框架成本较大
 * 2.违背单一职责原则，计数器框架与业务代码无关
 * @author xiaochuang.mao
 * @date 2020/5/21 13:19
 */
public class UserController {

    /** 这里去依赖注入下MetricsController*/
    private MetricsCollector metricsCollector;

    /**
     * 登录伪代码
     * @param userName String 用户名
     * @param password String 密码
     * @return Object
     */
    public Object login(String userName, String password) {
        long startTime = System.currentTimeMillis();
        // TODO: 2020/5/21 login逻辑
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        // TODO: 2020/5/21 返回数据
        return new Object();
    }

    /**
     * 注册
     * @param userName String 用户名
     * @param password String 密码
     * @return Object
     */
    public Object register(String userName, String password) {
        long startTime = System.currentTimeMillis();
        // TODO: 2020/5/21 register逻辑
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        // TODO: 2020/5/21 返回数据
        return new Object();
    }

}
