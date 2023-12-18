package com.example.demospringboot.entity;

import lombok.Data;

@Data
public class InviteCode {
  public long id;
  public String code;
  public long userId;
}
