package com.hz.springsecunity01.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@RequestMapping("/hello")
    public String hello(){
    System.out.println("12");
    return "hello";
}

}
