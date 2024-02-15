package com.alfredoLibrary.alfredoLibrary.Controllers;


import org.springframework.web.bind.annotation.RestController;

@RestController @ReaquestMapping("hallo")
public class halloController {

  @GetMapping("user")
  public String helloUser(){
    return "hallo user";
  }
  

}
