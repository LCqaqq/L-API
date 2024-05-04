package com.example.lapiinterface;

import com.example.lapiinterface.client.HttpClient;
import com.example.lapiinterface.model.User;

public class Main {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        String result1 = httpClient.getNameByGet("LC");
        String result2 =httpClient.getNameByPost("LC");
        User user = new User();
        user.setName("lc");
        String result3 = httpClient.getUser(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
