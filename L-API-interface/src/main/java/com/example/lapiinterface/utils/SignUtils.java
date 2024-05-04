package com.example.lapiinterface.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

/**
 * 签名工具
 */
public class SignUtils {
    /**
     * 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body,String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body.toString()+"."+secretKey;
        return md5.digestHex(content);
    }
}
