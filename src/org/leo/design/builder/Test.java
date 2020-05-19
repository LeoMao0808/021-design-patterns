package org.leo.design.builder;

/**
 * 模块名称: CRM
 * 模块描述: 测试类
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 18:42
 */
public class Test {

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.ResourcePoolConfigBuilder()
                .setName("dbpool")
                .setMaxIdle(9)
                .setMaxTotal(10)
                .setMinIdle(1)
                .build();
    }
}
