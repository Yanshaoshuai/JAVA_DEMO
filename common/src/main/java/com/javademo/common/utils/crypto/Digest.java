package com.javademo.common.utils.crypto;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class Digest {
    public Digest(){}
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String SHA256 = "SHA256";
    public static final String SHA512 = "SHA512";

    public static String digest(String content, Charset charset, String alg){
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] digestBytes = messageDigest.digest(content.getBytes(charset));
        return toHexZeroPadding(digestBytes);
    }
    /**
     * byte 数组 每位转成2位16进制字符串
     * 数拼接成字符串返回
     * @param bytes
     * @return
     */
    public static String toHexZeroPadding(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            sb.append(String.format("%02X", aByte));
        }
        return sb.toString();
    }
}
