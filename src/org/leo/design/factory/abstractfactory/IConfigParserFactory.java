package org.leo.design.factory.abstractfactory;

import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.systemconfig.ISystemConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:39
 */
public interface IConfigParserFactory {

    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();
}
