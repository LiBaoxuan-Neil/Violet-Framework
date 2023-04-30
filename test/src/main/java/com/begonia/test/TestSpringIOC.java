package com.begonia.test;

import com.begonia.factory.DefaultListableBeanFactory;
import com.begonia.po.User;
import com.begonia.reader.XmlBeanDefinitionReader;
import com.begonia.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:25 PM
 */
public class TestSpringIOC {

    private DefaultListableBeanFactory beanFactory ;

    @Before
    public void init() {
        beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("beans.xml");
    }
    @Test
    public void test(){
        // 职场老男人
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 以下代码才是测试人员需要的代码
        Map<String,Object> map = new HashMap<>();
        map.put("username","千场老亚瑟");
        List<User> users = userService.queryUsers(map);
        System.out.println(users);
    }
}
