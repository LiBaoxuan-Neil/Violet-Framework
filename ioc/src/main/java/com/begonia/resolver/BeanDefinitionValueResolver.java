package com.begonia.resolver;

import com.begonia.factory.BeanFactory;
import com.begonia.handler.IntegerTypeHandler;
import com.begonia.handler.StringTypeHandler;
import com.begonia.handler.TypeHandler;
import com.begonia.model.RuntimeBeanReference;
import com.begonia.model.TypedStringValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理Bean定义中的成员变量
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:34 PM
 */
public class BeanDefinitionValueResolver {

    private BeanFactory beanFactory;

    //策略集合
    private List<TypeHandler> typeHandlers = new ArrayList<>();

    public BeanDefinitionValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        initTypeHandlers();
    }

    private void initTypeHandlers() {
        typeHandlers.add(new IntegerTypeHandler());
        typeHandlers.add(new StringTypeHandler());
    }

    public Object resoleValue(Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference reference = (RuntimeBeanReference) value;
            String name = reference.getRef();
            return beanFactory.getBean(name);
        } else if (value instanceof TypedStringValue) {
            TypedStringValue typedStringValue = (TypedStringValue) value;
            String stringValue = typedStringValue.getValue();
            Class<?> targetType = typedStringValue.getTargetType();
            if (targetType != null) {
                TypeHandler typeHandler = getTypeHandler(targetType);
                return typeHandler.handleType(stringValue);
            }
            return stringValue;
        }
        return null;
    }

    private TypeHandler getTypeHandler(Class<?> targetType) {
        for (TypeHandler handler : typeHandlers) {
            if (handler.supports(targetType)) {
                return handler;
            }
        }
        return null;
    }
}
