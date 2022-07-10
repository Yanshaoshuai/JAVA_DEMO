package com.javademo.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

public class CryptoUtilTest {


    private final static Logger LOG = LoggerFactory.getLogger(JWTUtilTest.class);

    /**
     * 散列函数 哈希 消息摘要
     * 保证文件或者值的安全
     * MD5
     * SHA1
     * SHA256
     * SHA512
     */


    /**
     * 对称加密
     * DES Data Encryption Standard 数据加密标准
     * AES Advanced Encryption Standard 高级加密标准
     * 加密解密使用同一密钥--流加密(每个元素作为加密单元)/块加密(先分块,再以块为单位加密)
     */
    @Test
    public void testDESAES() {
        //DES密钥必须是8字节
        //AES密钥必须是16字节

        //transformation 加密算法/加密模式/填充模式
        // ECB/PKCS5Padding是默认值
        Map<String, String> transformationKeyMap =
                Map.of("DES/ECB/PKCS5Padding", "12345678", "AES/ECB/PKCS5Padding", "1234567812345678",
                        "DES/CBC/PKCS5Padding", "12345678", "AES/CBC/PKCS5Padding", "1234567812345678",
                        //NoPadding DES明文必须是8字节正数倍 AES明文必须是16字节整数倍
                        "DES/ECB/NoPadding", "12345678", "AES/ECB/NoPadding", "1234567812345678",
                        "DES/CBC/NoPadding", "12345678", "AES/CBC/NoPadding", "1234567812345678");

        String content = "0123456701234567";
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        for (Map.Entry<String, String> entry : transformationKeyMap.entrySet()) {
            try {
                String key = entry.getValue();
                String transformation = entry.getKey();
                String[] transArr = transformation.split("/");

                LOG.info("----------{} started-------", transformation);
                Cipher cipher = Cipher.getInstance(transformation);
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), transArr[0]);
                if("CBC".equals(transArr[1])){
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,new IvParameterSpec(key.getBytes()));
                }else cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

                byte[] bytes = cipher.doFinal(content.getBytes());
                LOG.info("encode bytes {}", Arrays.toString(bytes));
                String s = encoder.encodeToString(bytes);
                LOG.info("encode bytes base64 string {}", s);

                byte[] decodeBytes = decoder.decode(s);
                if("CBC".equals(transArr[1])){
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,new IvParameterSpec(key.getBytes()));
                }else cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] bytes1 = cipher.doFinal(decodeBytes);
                LOG.info("decode content is {}", new String(bytes1, StandardCharsets.UTF_8));
                LOG.info("----------{} end-------", transformation);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                     IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * base64是可读性算法不是加密算法
     * 把原字符三个字节分为一组,一个字节8位共24位
     * base64把24位个分成4组，每组6位,把每组高位补00得到一个[0-63]直接的索引
     * 从下面编码表找到对应索引的字符即为base64编码的字符
     * (不够24位的部分依旧按照6位一组,有数据但不够6位的末尾补0,完全没有数据的用=填充)
     * <p>
     * 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
     * 'I', 'J', 'K', 'L', 'M','N', 'O', 'P',
     * 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
     * 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
     * 'g', 'h', 'i', 'j', 'k', 'l', 'm','n',
     * 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
     * 'w', 'x', 'y', 'z','0', '1', '2', '3',
     * '4', '5', '6', '7', '8', '9', '+', '/'
     */
    @Test
    public void testBase64() {
        Base64.Encoder encoder = Base64.getEncoder();
        //00000001
        //000000 01 => 000000 010000 = =
        //0 16 = = => AQ==
        byte[] byte1 = new byte[]{1};
        LOG.info(encoder.encodeToString(byte1));
        //00000001 00000000
        //000000 010000 0000=>000000 010000 000000 =
        // 0 16 0 = => AQA=
        byte[] byte2 = new byte[]{1, 0};
        LOG.info(encoder.encodeToString(byte2));
        //00000001 00000000 00000000
        //000000 010000 000000 000000
        //0 16 0 0=>AQAA
        byte[] byte3 = new byte[]{1, 0, 0};
        LOG.info(encoder.encodeToString(byte3));
    }
    //非对称加密
    //--公钥加密私钥解密/私钥加密公钥解密
}
