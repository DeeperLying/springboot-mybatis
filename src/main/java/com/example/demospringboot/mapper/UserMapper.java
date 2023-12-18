package com.example.demospringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demospringboot.entity.User;

@Mapper
@Repository
public interface UserMapper {
  public List<User> queryAll();

  public List<User> lookForSameUserName(String userName);

  public int createUser(User user);

  public List<User> lookForSameUserId(long userId);
}
