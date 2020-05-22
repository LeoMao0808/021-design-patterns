package org.leo.design.structural.proxy.right.base;

import org.leo.design.structural.proxy.right.base.IUserController;

/**
 * 模块名称: CRM
 * 模块描述: 原始类伪代码
 *
 * @author xiaochuang.mao
 * @date 2020/5/22 13:30
 */
public class UserController implements IUserController {
    @Override
    public Object login(String telephone, String password) {
        //...省略login逻辑...
        return new Object();
    }

    @Override
    public Object register(String telephone, String password) {
        //...省略register逻辑...
        return new Object();
    }
}
