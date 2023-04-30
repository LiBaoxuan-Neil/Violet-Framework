package com.begonia.resource;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 7:32 PM
 */
public class ClasspathResource implements Resource{

    private String location;

    public ClasspathResource(String location) {
        this.location = location;
    }

    @Override
    public InputStream getInputStream() {
        if (location.startsWith("classpath:")){
            location = location.substring(10);
        }
        // 读取classpath路径资源的方式
        return this.getClass().getClassLoader().getResourceAsStream(location);
    }
}
