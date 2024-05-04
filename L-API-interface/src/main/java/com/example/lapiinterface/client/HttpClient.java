package com.example.lapiinterface.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.lapiinterface.model.User;

import com.example.lapiinterface.utils.SignUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HttpClient {

    private String accessKey = "LCC";
    private String secretKey = "abcdefgh";


    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result3= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }


    public String getNameByPost(@RequestParam String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result3= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }

    private Map<String,String> getHeaderMap(String body){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign", SignUtils.getSign(body,secretKey));
        return hashMap;
    }

    /**
     * 请求时带上API签名需要传递
     * @param user
     * @return
     */
    public String getUser(@RequestBody User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse =HttpRequest.post("http://localhost:8123/api/name/user")
                .body(json)
                .addHeaders(getHeaderMap(json))
                .execute();

        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }


}
