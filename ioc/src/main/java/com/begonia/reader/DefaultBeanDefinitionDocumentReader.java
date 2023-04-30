package com.begonia.reader;

import com.begonia.registry.BeanDefinitionRegistry;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:08 PM
 */
public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader{

    private BeanDefinitionRegistry registry;

    public DefaultBeanDefinitionDocumentReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void registerBeanDefinitions(Element rootElement) {
        BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(registry);

        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String name = element.getName();
            if (name.equals("bean")){
                delegate.parseDefaultElement(element);
            }else{
                delegate.parseCustomElement(element);
            }
        }
    }
}
