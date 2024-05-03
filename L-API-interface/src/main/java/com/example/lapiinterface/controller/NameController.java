package com.example.lapiinterface.controller;

import com.example.lapiinterface.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){
        return "GET 你的名字是:"+name;
    }

    @PostMapping("/")
    public String getNameByPost(String name){
        return "POST 你的名字是:"+name;
    }

    @PostMapping("/user")
    public String getUser(@RequestParam User user){
        return "POST 你的名字是:"+user.getName();
    }
}
