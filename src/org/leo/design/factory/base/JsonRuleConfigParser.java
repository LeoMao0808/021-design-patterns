package org.leo.design.factory.base;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/18 12:57
 */
public class JsonRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        System.out.println("JsonRuleConfigParser....");
        return new RuleConfig();
    }
}
