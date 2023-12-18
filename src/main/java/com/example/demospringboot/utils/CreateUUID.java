package com.example.demospringboot.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CreateUUID {
  public static String generateInviteCode(Long userId) {
    // 通过UUID生成唯一标识符
    UUID uuid = UUID.randomUUID();
    String uuidString = uuid.toString();

    // 去掉UUID中的横线
    String cleanUuid = uuidString.replaceAll("-", "");

    // 截取一部分作为邀请码
    String inviteCode = cleanUuid.substring(0, 30);

    // 添加用户ID作为前缀
    inviteCode = userId.toString() + inviteCode;
    return inviteCode;
  }
}
