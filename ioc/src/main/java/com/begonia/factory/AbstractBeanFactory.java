package com.begonia.factory;

import com.begonia.model.BeanDefinition;
import com.begonia.registry.DefaultSingletonBeanRegistry;

/**
 * 该类主要负责去制定getBean的流程，至于创建Bean或者获取BeanDefinition的细节该类不负责
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 9:26 AM
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 定义获取bean流程
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        // 1.在单例Bean集合中查找指定beanName的Bean实例是否存在
        Object bean = getSingleton(name);
        // 2.如果存在则直接返回
        if (bean != null){
            return bean;
        }
        // BeanDefinition的获取存在多种方法，比如XMl、注解等，所以AbstractBeanFactory就不去具体实现BeanDefinition获取
        BeanDefinition bd = getBeanDefinition(name);
        if (bd == null){
            return null;
        }
        if (bd.isSingleton()){
            bean = createBean(bd);
            addSingleton(name,bean);
        }else if (bd.isPrototype()){
            bean = createBean(bd);
        }

        return bean;
    }

    /**
     * 延迟到AbstractAutowireCapableBeanFactory区实现该方法
     * @param bd
     * @return
     */
    protected abstract Object createBean(BeanDefinition bd);

    /**
     * 延迟到DefaultListableBeanFactory区实现该方法
     * @param name
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String name);
}
