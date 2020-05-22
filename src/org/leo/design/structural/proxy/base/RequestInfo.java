package org.leo.design.structural.proxy.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/21 13:21
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestInfo {
    private String methodName;
    private Long startTime;
    private Long responseTime;
}
