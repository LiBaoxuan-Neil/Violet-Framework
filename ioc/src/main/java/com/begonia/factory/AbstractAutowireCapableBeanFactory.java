package com.begonia.factory;

import com.begonia.model.BeanDefinition;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:28 PM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(BeanDefinition bd) {
        return null;
    }
}
