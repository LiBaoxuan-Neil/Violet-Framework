package com.begonia.registry;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:17 PM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
    @Override
    public Object getSingleton(String name) {
        return null;
    }

    @Override
    public void addSingleton(String name, Object bean) {

    }
}
