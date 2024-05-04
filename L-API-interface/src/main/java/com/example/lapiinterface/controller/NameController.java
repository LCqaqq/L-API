package com.example.lapiinterface.controller;


import com.example.lapiinterface.model.User;
import com.example.lapiinterface.utils.SignUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){
        return "GET 你的名字是:"+name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是:"+name;
    }

    @PostMapping("/user")
    public String getUser(@RequestBody User user,HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 校验是否拥有API认证
        if (!accessKey.equals("LCC")){
            throw new RuntimeException("未拥有权限");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("未拥有权限");
        }
        // todo 后端重新生成sign
        String serverSign = SignUtils.getSign(body,"abcdefgh");
        if (!serverSign.equals(sign)){
            throw new RuntimeException("未拥有权限");
        }
        return "POST 你的名字是:"+user.getName();
    }
}
