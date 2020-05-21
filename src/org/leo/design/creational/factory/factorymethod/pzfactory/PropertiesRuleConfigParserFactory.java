package org.leo.design.creational.factory.factorymethod.pzfactory;

import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.PropertiesRuleConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: properties
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:18
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
