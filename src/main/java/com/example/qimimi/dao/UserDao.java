package com.example.qimimi.dao;

import com.example.qimimi.mapper.UserMapper;
import com.example.qimimi.pojo.User;
import com.example.qimimi.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    public List<User> findUserByNickName(String nickName) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNickNameEqualTo(nickName);
        return userMapper.selectByExample(userExample);
    }

    public Integer AddUser(User user) {
       return userMapper.insert(user);
    }

    public Integer DeleteUserByNikeName(String nikeName) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNickNameEqualTo(nikeName);
        return userMapper.deleteByExample(userExample);
    }

    public User LoginUser(String username, String password) {
        return userMapper.LoginUser(username,password);
    }

    public Integer UpdateUserById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
