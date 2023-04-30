package com.begonia.service;

import com.begonia.po.User;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:34 PM
 */
public interface UserService {
    List<User> queryUsers(Map<String, Object> param);

}
