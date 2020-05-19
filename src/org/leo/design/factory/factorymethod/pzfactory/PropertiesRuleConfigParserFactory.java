package org.leo.design.factory.factorymethod.pzfactory;

import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.PropertiesRuleConfigParser;
import org.leo.design.factory.factorymethod.pzfactory.IRuleConfigParserFactory;

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
