package org.leo.design.factory.base.systemconfig;

import org.leo.design.factory.base.SystemConfig;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 17:15
 */
public interface ISystemConfigParser {
    SystemConfig parser(String configKey);
}
