package com.example.demospringboot.entity;

import lombok.Data;

@Data
public class MessageEntity {
  public String content;
  public String type;
  public String userId;
}
