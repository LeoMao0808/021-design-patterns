package org.leo.design.creational.factory.factorymethod.pzfactory;

import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.YamlRuleConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: yaml
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:17
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
