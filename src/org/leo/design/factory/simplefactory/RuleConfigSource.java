package org.leo.design.factory.simplefactory;

import org.leo.design.factory.base.JsonRuleConfigParser;
import org.leo.design.factory.base.PropertiesRuleConfigParser;
import org.leo.design.factory.base.IRuleConfigParser;
import org.leo.design.factory.base.RuleConfig;
import org.leo.design.factory.base.YamlRuleConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/18 13:01
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigFactory.createParser(fileExtension);
        if (parser == null) {
            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //解析路径获取扩展名，如rule.json
        return "json";
    }
}
