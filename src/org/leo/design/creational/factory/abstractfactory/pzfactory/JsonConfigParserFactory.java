package org.leo.design.creational.factory.abstractfactory.pzfactory;

import org.leo.design.creational.factory.abstractfactory.IConfigParserFactory;
import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.systemconfig.ISystemConfigParser;
import org.leo.design.creational.factory.base.JsonRuleConfigParser;
import org.leo.design.creational.factory.base.systemconfig.JsonSystemConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 17:22
 */
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
