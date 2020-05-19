package org.leo.design.factory.simplefactory;

import com.sun.deploy.util.StringUtils;
import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.JsonRuleConfigParser;
import org.leo.design.factory.base.PropertiesRuleConfigParser;
import org.leo.design.factory.base.RuleConfig;
import org.leo.design.factory.base.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块名称: CRM
 * 模块描述: 简单工厂
 *
 * @author xiaochuang.mao
 * @date 2020/5/18 13:13
 */
public class RuleConfigFactory {
    /**缓存Parser*/
    private static final Map<String , IRuleConfigParser> cacheParser = new HashMap(16);

    static {
        cacheParser.put("json",new JsonRuleConfigParser());
        cacheParser.put("yaml",new YamlRuleConfigParser());
        cacheParser.put("properties",new PropertiesRuleConfigParser());
    }


    public static IRuleConfigParser createParser(String fileExtension) {
        //第一种简单工厂
//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(fileExtension)) {
//            parser = new JsonRuleConfigParser();
//        }  else if ("yaml".equalsIgnoreCase(fileExtension)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(fileExtension)) {
//            parser = new PropertiesRuleConfigParser();
//        }
//        return parser;
        //第二种简单工厂
        if (fileExtension ==null || fileExtension.isEmpty()){
            return null;
        }
        return cacheParser.get(fileExtension);
    }
}
