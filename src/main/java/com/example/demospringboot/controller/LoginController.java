package com.example.demospringboot.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

  @GetMapping("/login")
  public String getMethodName(@RequestParam String param) {
    ArrayList<String> order = new ArrayList<String>();
    order.add("123");

    return "login success";
  }

}