package com.example.demospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.services.UserServicesImpl;
import com.example.demospringboot.common.ResultCommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserServicesImpl userServicesImpl;

  @GetMapping("/all")
  public String getMethodName() {
    System.out.println("br=====================");
    List<User> userList = userServicesImpl.queryAll();
    System.out.print(userList);
    return "success user/all";
  }

  @PostMapping("/create")
  public ResultCommon postMethodName(@RequestBody User user) {
    int isCreate = userServicesImpl.createUser(user);

    if (isCreate != 0) {
      return new ResultCommon<String>(200, "SUCCESS", "true");
    }

    Map<String, Object> response = new HashMap(0);
    response.put("data", "Create user fail");

    return new ResultCommon<Map>(400, "FAIL", response);
  }

}
