package org.leo.design.creational.factory.base;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/18 12:59
 */
public class YamlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        System.out.println("YamlRuleConfigParser...");
        return new RuleConfig();
    }
}
