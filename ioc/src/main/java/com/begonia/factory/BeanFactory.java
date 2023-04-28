package com.begonia.factory;

/**
 * BeanFactory体系中的顶级接口
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 9:18 AM
 */
public interface BeanFactory {

    Object getBean(String name);

}
