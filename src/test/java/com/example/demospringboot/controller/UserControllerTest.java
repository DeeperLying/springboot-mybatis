package com.example.demospringboot.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demospringboot.entity.User;

@SpringBootTest
public class UserControllerTest {

  @Autowired
  UserController userController;

  @Test
  void testGetMethodName() {
    String result = userController.getMethodName();
    System.out.println(result + "=======");
  }

  @Test
  void testPostMethodName() {
    User user = new User();
    user.setPassword("123");
    user.setUserName("Test name1");
    userController.postMethodName(user);

  }

  @AfterAll
  public static void testAfter() {
    System.out.println("测试结束================");
  }
}
