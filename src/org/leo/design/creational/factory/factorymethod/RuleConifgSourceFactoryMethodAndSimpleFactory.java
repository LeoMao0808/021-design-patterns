package org.leo.design.creational.factory.factorymethod;

import org.leo.design.creational.factory.base.IRuleConfigParser;
import org.leo.design.creational.factory.base.RuleConfig;
import org.leo.design.creational.factory.factorymethod.pzfactory.IRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.JsonRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.PropertiesRuleConfigParserFactory;
import org.leo.design.creational.factory.factorymethod.pzfactory.YamlRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块名称: CRM
 * 模块描述: 工厂方法和简单工厂
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:19
 */
public class RuleConifgSourceFactoryMethodAndSimpleFactory {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null){
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
//因为工厂类只包含方法，不包含成员变量，完全可以复用，
//不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
class RuleConfigParserFactoryMap{
    private  static final Map<String,IRuleConfigParserFactory> cachedFactories = new HashMap<>(16);
    static {
        cachedFactories.put("json",new JsonRuleConfigParserFactory());
        cachedFactories.put("yaml",new YamlRuleConfigParserFactory());
        cachedFactories.put("properties",new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()){
            return null;
        }
        IRuleConfigParserFactory iRuleConfigParserFactory = cachedFactories.get(type);
        return iRuleConfigParserFactory;
    }
}
