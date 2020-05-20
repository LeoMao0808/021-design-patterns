package org.leo.design.prototype.example;

import org.leo.design.prototype.base.SearchWord;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模块名称: design
 * 模块描述: 
 * 每次从数据库中查询更新hashmap中的值
 *
 * @author xiaochuang.mao
 * @date 2020/5/20 16:49
 */
public class Case1 {
    private final ConcurrentHashMap<String, SearchWord> concurrentHashMap = new ConcurrentHashMap<>();
    private  Long lastUpdateTime = -1L;

    public void refresh() {
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中 
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime); 
        Long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > lastUpdateTime){
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if(concurrentHashMap.containsKey(searchWord.getKeyWord())){
                concurrentHashMap.replace(searchWord.getKeyWord(),searchWord);
            } else {
                concurrentHashMap.put(searchWord.getKeyWord(),searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(Long lastUpdateTime) {
        // TODO: 2020/5/20 从数据库中取出更新时间  > lastUpdate
        return Collections.emptyList();
    }
}
