package org.leo.design.factory.abstractfactory.pzfactory;

import org.leo.design.factory.abstractfactory.IConfigParserFactory;
import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.YamlRuleConfigParser;
import org.leo.design.factory.base.systemconfig.ISystemConfigParser;
import org.leo.design.factory.base.systemconfig.YamlSystemConfigParser;

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
