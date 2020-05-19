package org.leo.design.factory.factorymethod.pzfactory;

import org.leo.design.factory.base.IRuleConfigParser;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 13:14
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
