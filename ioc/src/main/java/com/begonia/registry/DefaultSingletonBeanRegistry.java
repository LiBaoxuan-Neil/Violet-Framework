package com.begonia.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:17 PM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        //TODO 学完单例模式的知识点之后，需要将此次改造成双重检查锁模式去获取单例的bean
        return this.singletonObjects.get(name);
    }

    @Override
    public void addSingleton(String name, Object bean) {
        //TODO 为了解决循环依赖，其实spring定义了三个缓存，那么这三个缓存中不能同时存在同一个bean
        this.singletonObjects.put(name, bean);
    }
}
