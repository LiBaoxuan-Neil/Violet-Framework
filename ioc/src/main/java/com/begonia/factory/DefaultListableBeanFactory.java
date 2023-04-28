package com.begonia.factory;

import com.begonia.model.BeanDefinition;
import com.begonia.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 拥有BeanFactory的所有功能
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:41 PM
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return beanDefinitions.get(name);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition bd) {
        beanDefinitions.put(name, bd);
    }
}
