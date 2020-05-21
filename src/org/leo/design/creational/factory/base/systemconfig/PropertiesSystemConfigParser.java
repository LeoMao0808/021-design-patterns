package org.leo.design.creational.factory.base.systemconfig;

import org.leo.design.creational.factory.base.SystemConfig;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 17:25
 */
public class PropertiesSystemConfigParser implements ISystemConfigParser{
    @Override
    public SystemConfig parser(String configKey) {
        return new SystemConfig();
    }
}
