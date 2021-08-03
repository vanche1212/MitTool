package com.zrtg.mittoolcommon.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class RsaUtils {

    /**
     * 公钥加密
     *
     * @param publicKey
     * @param val
     * @return
     */
//    public static String encode(String publicKey, String val) {
//        //hutool的Rsa工具
//        RSA rsa = new RSA(null, publicKey);
//        //字符串转字节数组
//        byte[] bytes = StrUtil.bytes(val, CharsetUtil.CHARSET_UTF_8);
//        //加密
//        byte[] encrypt = rsa.encrypt(bytes, KeyType.PublicKey);
//        //字节转16进制
//        String str = HexUtil.encodeHexStr(encrypt);
//        //16进制转base64
//        String encode = Base64.encode(str);
//        return encode;
//    }

    /**
     * 公钥加密
     *
     * @param publicKey
     * @param val
     * @return
     */
    public static String encode(String publicKey, String val) {
        //hutool的Rsa工具
        RSA rsa = new RSA(null, publicKey);
        //加密
        byte[] encrypt = rsa.encrypt(val, KeyType.PublicKey);
        //字节数组转字符串
        String str = StrUtil.str(encrypt, CharsetUtil.CHARSET_UTF_8);
        return str;
    }


    /**
     * 私钥解密
     *
     * @param privateKey
     * @param val
     * @return
     */
//    public static String decode(String privateKey, String val) {
//        RSA rsa = new RSA(privateKey, null);
//        //base转解码,解码后是16进制
//        String base64Str = Base64.decodeStr(val);
//        //16进制转字节数组
//        byte[] bytes = HexUtil.decodeHex(base64Str);
//        //私钥解密
//        byte[] decrypt = rsa.decrypt(bytes, KeyType.PrivateKey);
//        //字节数组转字符串
//        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
//        return str;
//    }


    /**
     * 私钥解密
     *
     * @param privateKey
     * @param val
     * @return
     */
    public static String decode(String privateKey, String val) {
        RSA rsa = new RSA(privateKey, null);
        //私钥解密
        byte[] decrypt = rsa.decrypt(val, KeyType.PrivateKey);
        //字节数组转字符串
        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
        return str;
    }


}
