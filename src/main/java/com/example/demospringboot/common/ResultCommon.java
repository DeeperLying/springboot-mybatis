package com.example.demospringboot.common;

import lombok.Data;

@Data
public class ResultCommon<T> {
  private int code;

  private String message;

  private T data;

  // public ResultCommon(Integer code, String message) {
  // this.code = code;
  // this.message = message;
  // }

  public ResultCommon(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public ResultCommon(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}