package com.begonia.reader;

import com.begonia.resource.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 8:19 PM
 */
public interface BeanDefinitionReader {
    // 方法重载的作用：很多时候，是给调用者更多的选择
    void loadBeanDefinitions(String location);

    void loadBeanDefinitions(Resource resource);
}
