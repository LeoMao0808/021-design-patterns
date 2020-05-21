package org.leo.design.creational.prototype.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 模块名称: CRM
 * 模块描述: TODO
 *
 * @author xiaochuang.mao
 * @date 2020/5/20 16:51
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchWord {
    private String keyWord;
    private Integer count;
    private Long lastUpdateTime;
}
