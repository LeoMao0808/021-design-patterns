package org.leo.design.builder;

import lombok.Getter;

/**
 * 模块名称: CRM
 * 模块描述: 资源池配置类
 *
 * @author xiaochuang.mao
 * @date 2020/5/19 18:27
 */
@Getter
public class ResourcePoolConfig {
    private final String name;
    private final Integer maxTotal;
    private final Integer maxIdle;
    private final Integer minIdle;

    public ResourcePoolConfig(ResourcePoolConfigBuilder builder) {
        name = builder.name;
        maxTotal = builder.maxTotal;
        maxIdle = builder.maxIdle;
        minIdle = builder.minIdle;
    }

    //我们将Builder类设计成了ResourcePoolConfig的内部类。
    // 我们也可以将Builder类设计成独立的非内部类ResourcePoolConfigBuilder
    public static class ResourcePoolConfigBuilder {

        private static final Integer DEFAULT_MAX_TOTAL = 8;
        private static final Integer DEFAULT_MAX_IDLE = 8;
        private static final Integer DEFAULT_MIN_IDLE = 0;
        private Integer maxTotal = DEFAULT_MAX_TOTAL;
        private Integer maxIdle = DEFAULT_MAX_IDLE;
        private Integer minIdle = DEFAULT_MIN_IDLE;
        private String name;

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (name == null && name.isEmpty()) {
                throw new IllegalArgumentException("name必填");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxTotal需要大于maxIdle");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("minidle 需要小于maxtotal或者maxidle");
            }
            return new ResourcePoolConfig(this);
        }

        public ResourcePoolConfigBuilder setName(String name) {
            if (name == null && name.isEmpty()) {
                throw new IllegalArgumentException("name不能为空");
            }
            this.name = name;
            return this;
        }

        public ResourcePoolConfigBuilder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal需要大于等于0");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public ResourcePoolConfigBuilder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxidle需要大于0");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourcePoolConfigBuilder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minidle需要大于0");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
    /**
     * 如果一个类中有很多属性，为了避免构造函数的参数列表过长，影响代码的可读性和易用性，
     * 我们可以通过构造函数配合 set() 方法来解决。但是，如果存在下面情况中的任意一种，
     * 我们就要考虑使用建造者模式了。
     *
     * 我们把类的必填属性放到构造函数中，强制创建对象的时候就设置。如果必填的属性有很多，
     * 把这些必填属性都放到构造函数中设置，那构造函数就又会出现参数列表很长的问题。
     * 如果我们把必填属性通过 set() 方法设置，那校验这些必填属性是否已经填写的逻辑就无处安放了。
     *
     * 如果类的属性之间有一定的依赖关系或者约束条件，我们继续使用构造函数配合 set() 方法
     * 的设计思路，那这些依赖关系或约束条件的校验逻辑就无处安放了。
     *
     * 如果我们希望创建不可变对象，也就是说，对象在创建好之后，就不能再修改内部的属性值，
     * 要实现这个功能，我们就不能在类中暴露 set() 方法。构造函数配合 set() 方法来
     * 设置属性值的方式就不适用了。
     */
}
