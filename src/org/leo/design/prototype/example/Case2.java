package org.leo.design.prototype.example;

import org.leo.design.prototype.base.SearchWord;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模块名称: design
 * 模块描述: 不使用设计模式实现
 * 特殊的要求：任何时刻，系统 A 中的所有数据都必须是同一个版本的，要么都是版本 a，
 * 要么都是版本 b，不能有的是版本 a，有的是版本 b。那刚刚的更新方式就不能满足这个要求了。
 * 除此之外，我们还要求：在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 *
 * @author xiaochuang.mao
 * @date 2020/5/20 16:49
 */
public class Case2 {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    public void refresh() {
        HashMap<String,SearchWord> newKeywords = new LinkedHashMap<>();
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中 
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyWord(),searchWord);
        }
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        // TODO: 2020/5/20 从数据库中取出所有数据
        return Collections.emptyList();
    }
}
