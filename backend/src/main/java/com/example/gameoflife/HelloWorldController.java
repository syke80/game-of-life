package com.example.gameoflife;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/helloworld")
public class HelloWorldController {
  @RequestMapping("/")
  public String helloWorld() {
    return "Hello world";
  }
}
