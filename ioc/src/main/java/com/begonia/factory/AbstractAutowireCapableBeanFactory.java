package com.begonia.factory;

import com.begonia.model.BeanDefinition;
import com.begonia.model.PropertyValue;
import com.begonia.resolver.BeanDefinitionValueResolver;
import com.begonia.utils.ReflectUtils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:28 PM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(BeanDefinition bd) {
        // Bean实例化（new对象）
        Object bean = creatBeanInstance(bd);
        //Bean的依赖注入(setter方法)
        populateBean(bean, bd);
        //Bean的初始化（调用初始化方法，比如AOP代理对象的产生流程）
        initializeBean(bean, bd);
        return bean;
    }

    private void initializeBean(Object bean, BeanDefinition bd) {
        // init-method标签属性对应的初始化方法的调用
        invokeInitMethod(bean,bd);
    }

    private void invokeInitMethod(Object bean, BeanDefinition bd) {
        String initMethod = bd.getInitMethod();
        if (initMethod == null || "".equals(initMethod)) {
            return;
        }
        ReflectUtils.invokeMethod(bean, initMethod);
    }

    private void populateBean(Object bean, BeanDefinition bd) {
        List<PropertyValue> pvs = bd.getPropertyValues();
        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
        for (PropertyValue pv : pvs) {
            String name = pv.getName();
            Object value = pv.getValue();
            //真正要依赖注入的值
            Object valueToUse = valueResolver.resoleValue(value);
            ReflectUtils.setProperty(bean, name, valueToUse);
        }
    }

    private Object creatBeanInstance(BeanDefinition bd) {
        Object bean = ReflectUtils.newInstance(bd.getClazzType());
        return bean;
    }
}
