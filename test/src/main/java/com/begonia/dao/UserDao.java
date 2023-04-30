package com.begonia.dao;

import com.begonia.po.User;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:36 PM
 */
public interface UserDao {
    List<User> queryUserList(Map<String, Object> param);

}
