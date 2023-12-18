package com.example.demospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.common.ResultCommon;
import com.example.demospringboot.entity.InviteCode;
import com.example.demospringboot.mapper.InviteCodeMapper;
import com.example.demospringboot.services.UserServicesImpl;
import com.example.demospringboot.utils.CreateUUID;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/inviteCode")
public class InviteCodeController {

  @Autowired
  UserServicesImpl UserServicesImpl;

  @Autowired
  InviteCodeMapper inviteCodeMapper;

  @PostMapping("/create")
  public ResultCommon postMethodName(@RequestBody InviteCode inviteCode) {
    long userId = inviteCode.getUserId();
    int isExistUser = UserServicesImpl.lookForSameUserId(userId);
    System.out.println(isExistUser);

    if (isExistUser == 0) {
      return new ResultCommon(400, "User don't exist");
    }

    String code = CreateUUID.generateInviteCode(userId);
    inviteCode.setCode(code);

    int isSave = inviteCodeMapper.createInviteCode(inviteCode);

    if (isSave == 0) {
      return new ResultCommon(400, "Save fail");
    }

    Map<String, String> response = new HashMap(0);
    response.put("invite", code);
    return new ResultCommon<Map<String, String>>(200, "Create invite code success", response);
  }

}
