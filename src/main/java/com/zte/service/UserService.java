package com.zte.service;

import com.zte.mapper.UserMapper;
import com.zte.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public List<User> queryAll(){
        return userMapper.selectAll();
    }
}
