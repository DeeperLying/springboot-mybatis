package com.example.demospringboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.common.ResultCommon;
import com.example.demospringboot.utils.WebSocketServer;

import jakarta.websocket.Session;

@RestController
@RequestMapping("/im")
public class GetOnlineUser {
  @Autowired
  WebSocketServer WebSocketServer;

  @GetMapping("/onLineUserList")
  public ResultCommon<List<Map<String, Object>>> getOnlineUserList() {
    System.out.println(WebSocketServer.sessionPool);
    System.out.println(WebSocketServer.sessionPool.entrySet());

    List<Map<String, Object>> userList = new ArrayList<>();

    for (Map.Entry<String, Session> entry : WebSocketServer.sessionPool.entrySet()) {
        Map<String, Object> user = new HashMap<>();
        user.put("userId", entry.getKey());  // 用户ID
        user.put("sessionId", entry.getValue().getId());  // WebSocket Session ID
        userList.add(user);
    }

    return new ResultCommon<List<Map<String, Object>>>(200, "success", userList);
  }
}
