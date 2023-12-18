package com.example.demospringboot.services;

import java.util.List;

import com.example.demospringboot.entity.User;

public interface UserServicesI {
  public List<User> queryAll();

  public int createUser(User user);

  public int lookForSameUserId(long userId);
}
