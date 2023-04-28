package com.begonia.registry;

import com.begonia.model.BeanDefinition;

/**
 * 对外暴露BeanDefinitionRegistry的能力
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:06 PM
 */
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String name);

    void registerBeanDefinition(String name,BeanDefinition bd);
}
