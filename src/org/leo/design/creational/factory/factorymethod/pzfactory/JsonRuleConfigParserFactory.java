package org.leo.design.creational.factory.factorymethod.pzfactory;

import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.JsonRuleConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: Json
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:16
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
