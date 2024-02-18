package com.alfredoLibrary.alfredoLibrary.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("hallo")
public class halloController {

  @GetMapping("user")
  public String halloUser(){
    return "hallo user";
  }
  @GetMapping("admin")
  public  String halloAdmin(){
    return "hallo Admin";
  }
  

}


