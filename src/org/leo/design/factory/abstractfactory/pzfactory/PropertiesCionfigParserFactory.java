package org.leo.design.factory.abstractfactory.pzfactory;

import org.leo.design.factory.abstractfactory.IConfigParserFactory;
import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.PropertiesRuleConfigParser;
import org.leo.design.factory.base.systemconfig.ISystemConfigParser;
import org.leo.design.factory.base.systemconfig.PropertiesSystemConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 17:26
 */
public class PropertiesCionfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new PropertiesRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new PropertiesSystemConfigParser();
    }
}
