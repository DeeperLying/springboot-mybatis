package com.example.demospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.example.demospringboot.entity.User;
import com.example.demospringboot.mapper.UserMapper;

@Service
public class UserServicesImpl implements UserServicesI {

  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> queryAll() {
    System.out.println("ppppp");
    return userMapper.queryAll();
  }

  @Override
  public int createUser(User user) {
    String userName = user.getUserName();
    String password = user.getPassword();

    if (userName.isBlank() || password.isBlank()) {
      return 0;
    }

    List<User> isExist = userMapper.lookForSameUserName(user.getUserName());
    if (!isExist.isEmpty()) {
      return 0;
    }

    int isSave = userMapper.createUser(user);
    return isSave;
  }

  @Override
  public int lookForSameUserId(long userId) {
    List<User> user = userMapper.lookForSameUserId(userId);

    if (user.isEmpty()) {
      return 0;
    } else {
      return user.size();
    }
  }
}
