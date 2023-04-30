package com.begonia.dao;

import com.begonia.po.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 9:36 PM
 */
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> queryUserList(Map<String, Object> param) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Neil"));
        users.add(new User(2, "Tom"));
        users.add(new User(3, "king"));
        return users;
    }
}
