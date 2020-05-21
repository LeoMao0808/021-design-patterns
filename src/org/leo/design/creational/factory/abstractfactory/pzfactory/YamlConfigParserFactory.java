package org.leo.design.creational.factory.abstractfactory.pzfactory;

import org.leo.design.creational.factory.abstractfactory.IConfigParserFactory;
import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.YamlRuleConfigParser;
import org.leo.design.creational.factory.base.systemconfig.ISystemConfigParser;
import org.leo.design.creational.factory.base.systemconfig.YamlSystemConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 17:26
 */
public class YamlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new YamlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new YamlSystemConfigParser();
    }
}
