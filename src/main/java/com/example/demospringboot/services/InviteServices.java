package com.example.demospringboot.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospringboot.entity.InviteCode;
import com.example.demospringboot.mapper.UserMapper;

public class InviteServices {

  @Autowired
  UserMapper userMapper;

  public int createInviteCode(InviteCode inviteCode) {

    return 0;
  }
}
