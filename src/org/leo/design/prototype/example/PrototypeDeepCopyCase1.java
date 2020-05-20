package org.leo.design.prototype.example;

import org.leo.design.prototype.base.SearchWord;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模块名称: design
 * 模块描述: 使用原型设计模式实现 深拷贝
 * 特殊的要求：任何时刻，系统 A 中的所有数据都必须是同一个版本的，要么都是版本 a，
 * 要么都是版本 b，不能有的是版本 a，有的是版本 b。那刚刚的更新方式就不能满足这个要求了。
 * 除此之外，我们还要求：在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 *
 * 问题： 深拷贝要比浅拷贝耗时、耗内存空间。
 * @author xiaochuang.mao
 * @date 2020/5/20 16:49
 */
public class PrototypeDeepCopyCase1 {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private Long lastUpdateTime = -1L;

    public void refresh() {
        // 深拷贝
        // 第一种：递归拷贝对象
        HashMap<String,SearchWord> newKeywords = new HashMap<>();
        for (Map.Entry<String, SearchWord> searchWordEntry : currentKeywords.entrySet()) {
            SearchWord searchWord = searchWordEntry.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(), searchWord.getCount(), searchWord.getLastUpdateTime());
        }
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中 
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        Long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())){
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdateTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(Long lastUpdateTime) {
        // TODO: 2020/5/20 从数据库中取出 > lastUpdateTime；
        return Collections.emptyList();
    }
}
