package com.example.demospringboot.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.stereotype.Component;

import com.example.demospringboot.entity.MessageEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/api/websocket/{userId}")
public class WebSocketServer {

  private static final CopyOnWriteArraySet<Session> sessionList = new CopyOnWriteArraySet<>();

  private static final Map<String, Session> sessionPool = new HashMap<>();

  @OnOpen
  public void onOpen(@PathParam(value = "userId") String userId, Session session) {
    System.out.println(userId + "==========");
    System.out.println(session.getId());
    try {
      sessionList.add(session);
      sessionPool.put(userId, session);
      System.out.println("【WebSocket消息】有新的连接，总数为：" + sessionList.size());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @OnClose
  public void onClose(Session session) {
    try {
      sessionList.remove(session);
      System.out.println("【WebSocket消息】连接断开，总数为：" + sessionList.size());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @OnMessage
  public void onMessage(String message, Session session) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      MessageEntity messageEntity = mapper.readValue(message, MessageEntity.class);
      String content = messageEntity.getContent();
      String type = messageEntity.getType();

      if ("pong-ping".equals(type)) {
        session.getBasicRemote().sendText(message);
        return;
      }

      System.out.println("内容:" + content);

      // 将所有的消息全部转发出去
      for (Session s : sessionList) {
        if (s.equals(session)) {
          continue;
        }

        if (s.isOpen()) { // 确保会话是开着的
          s.getBasicRemote().sendText(message); // 使用原始消息字符串
          // 或者如果你想要更定制化的消息格式，也可以构造一个新的字符串或对象
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      // handle error
    }
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    System.out.println("发生错误");
    throwable.printStackTrace();
  }
}
