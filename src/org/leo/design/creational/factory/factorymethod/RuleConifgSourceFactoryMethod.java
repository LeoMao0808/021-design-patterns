package org.leo.design.creational.factory.factorymethod;

import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.RuleConfig;
import org.leo.design.creational.factory.factorymethod.pzfactory.IRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.JsonRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.PropertiesRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.YamlRuleConfigParserFactory;

/**
 * 模块名称: CRM
 * 模块描述: 工厂方法
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:19
 */
public class RuleConifgSourceFactoryMethod {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }

}
