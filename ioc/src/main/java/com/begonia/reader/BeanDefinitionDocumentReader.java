package com.begonia.reader;

import org.dom4j.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:09 PM
 */
public interface BeanDefinitionDocumentReader {

    void registerBeanDefinitions(Element rootElement);

}
