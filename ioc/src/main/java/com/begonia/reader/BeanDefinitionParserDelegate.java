package com.begonia.reader;

import com.begonia.model.BeanDefinition;
import com.begonia.model.PropertyValue;
import com.begonia.model.RuntimeBeanReference;
import com.begonia.model.TypedStringValue;
import com.begonia.registry.BeanDefinitionRegistry;
import com.begonia.utils.ReflectUtils;
import org.dom4j.Element;

import java.util.List;

/**
 * 委托模式
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:12 PM
 */
public class BeanDefinitionParserDelegate {

    private BeanDefinitionRegistry registry;

    public BeanDefinitionParserDelegate(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void parseDefaultElement(Element element) {
        String id = element.attributeValue("id");

        String clazzName = element.attributeValue("class");
        Class clazzType = ReflectUtils.resolveClassType(clazzName);
        String scope = element.attributeValue("scope");
        scope = scope == "" || scope == null ? "singleton" : scope;
        String initMethod = element.attributeValue("init-method");

        id = id == "" || id == null ? clazzType.getSimpleName() : id;


        BeanDefinition bd = new BeanDefinition(clazzName,id);
        bd.setScope(scope);
        bd.setInitMethod(initMethod);

        List<Element> elements = element.elements();
        parsePropertyElements(bd,elements);

        registry.registerBeanDefinition(id,bd);
    }

    public void parseCustomElement(Element element) {

    }

    private void parsePropertyElements(BeanDefinition bd, List<Element> elements) {
        for (Element element : elements) {
            parsePropertyElement(bd,element);
        }
    }

    private void parsePropertyElement(BeanDefinition bd, Element element) {
        String name = element.attributeValue("name");
        String value = element.attributeValue("value");
        String ref = element.attributeValue("ref");

        if (value!= "" && ref!= "" && value != null && ref != null ){
            return ;
        }
        if (value != "" && value != null){
            TypedStringValue typedStringValue = new TypedStringValue(value);
            Class targetType = ReflectUtils.resolveTargetType(bd.getClazzType(),name);
            typedStringValue.setTargetType(targetType);
            PropertyValue pv = new PropertyValue(name,typedStringValue);

            bd.addPropertyValue(pv);
        }else if(ref != "" && ref != null){
            RuntimeBeanReference reference = new RuntimeBeanReference(ref);
            PropertyValue pv = new PropertyValue(name,reference);
            bd.addPropertyValue(pv);
        }
    }
}
