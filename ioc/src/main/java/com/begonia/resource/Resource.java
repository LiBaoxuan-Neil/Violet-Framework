package com.begonia.resource;

import java.io.InputStream;

/**
 * 实现类：封装了资源信息
 * 接口：对外提供资源访问
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 6:23 PM
 */
public interface Resource {

    InputStream getInputStream();
}
