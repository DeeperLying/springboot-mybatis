package com.example.demospringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demospringboot.entity.InviteCode;

@SpringBootTest
public class CodeInviteControllerTest {

  @Autowired
  CodeInviteController codeInviteController;

  @Test
  void testPostMethodName() {
    InviteCode inviteCode = new InviteCode();
    inviteCode.setUserId(14);
    ;

    codeInviteController.postMethodName(inviteCode);
  }
}
