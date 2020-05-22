package org.leo.design.structural.proxy.right.base;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/22 13:28
 */
public interface IUserController {
    Object login(String telephone , String password);
    Object register(String telephone , String password);
}
