package com.begonia.registry;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:17 PM
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String name);

    void addSingleton(String name,Object bean);

}
