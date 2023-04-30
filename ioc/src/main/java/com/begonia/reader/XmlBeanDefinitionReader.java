package com.begonia.reader;

import com.begonia.registry.BeanDefinitionRegistry;
import com.begonia.resource.ClasspathResource;
import com.begonia.resource.Resource;
import com.begonia.utils.DocumentUtils;
import org.dom4j.Document;

import java.io.InputStream;

/**
 * 针对资源或者路径进行阅读
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:01 PM
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader{

    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void loadBeanDefinitions(String location) {
        Resource resource = new ClasspathResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) {
        InputStream stream = resource.getInputStream();
        Document document = DocumentUtils.getDocument(stream);

        DefaultBeanDefinitionDocumentReader documentReader = new DefaultBeanDefinitionDocumentReader(registry);
        documentReader.registerBeanDefinitions(document.getRootElement());
    }
}
