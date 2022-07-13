package com.javademo.common.utils;


import com.javademo.common.pojo.Transform;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

//todo try-catch异常 拆分到单独的包
public class CryptoUtil {
    private CryptoUtil() {
    }

    public static class MessageDigest{
        public MessageDigest(){}
        public static final String MD5 = "MD5";
        public static final String SHA1 = "SHA1";
        public static final String SHA256 = "SHA256";
        public static final String SHA512 = "SHA512";

        public static String digest(String content,Charset charset, String alg) throws NoSuchAlgorithmException {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(alg);
            byte[] digestBytes = messageDigest.digest(content.getBytes(charset));
            return CryptoUtil.toHexZeroPadding(digestBytes);
        }
    }
    public static class Asymmetric {
        public Asymmetric() {
        }

        public static final String ALG_RSA = "RSA";

        public static PublicKey generatePublicFromPrivateRSA(byte[] privateKeyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory kf = KeyFactory.getInstance(ALG_RSA);
            PrivateKey privateKey = kf.generatePrivate(spec);
            RSAPublicKeySpec rsaPrivateKey = (RSAPublicKeySpec) privateKey;
            return kf.generatePublic(new RSAPublicKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPublicExponent()));
        }

        public static PrivateKey loadPrivateKey(byte[] keyBytes, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance(algorithm);
            return kf.generatePrivate(spec);
        }

        public static PublicKey loadPublicKey(byte[] keyBytes, String algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance(algorithm);
            return kf.generatePublic(spec);
        }

        public byte[] encrypt(String content,Charset charset,Key key,String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
            Cipher cipher = Cipher.getInstance(alg);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            return cipher.doFinal(content.getBytes(charset));
        }
        public String encryptToBase64String(String content,Charset charset,Key key,String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
            Cipher cipher = Cipher.getInstance(alg);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] bytes = cipher.doFinal(content.getBytes(charset));
            return Base64.getEncoder().encodeToString(bytes);
        }
        public String decrypt(byte[] encryptBytes,Charset charset,Key key,String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
            Cipher cipher = Cipher.getInstance(alg);
            cipher.init(Cipher.DECRYPT_MODE,key);
            return new String(cipher.doFinal(encryptBytes),charset);
        }
        public String decryptFromBase64String(String encryptBase64Str,Charset charset,Key key,String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
            byte[] decode = Base64.getDecoder().decode(encryptBase64Str);
            return decrypt(decode,charset,key,alg);
        }
    }

    public static class Symmetric {
        public Symmetric() {
        }

        public static final String ALG_DES = "DES";
        public static final String ALG_AES = "AES";
        public static final String MOD_CBC = "CBC";
        public static final String MOD_ECB = "ECB";
        public static final String PADDING_PKCS5 = "PKCS5Padding";
        public static final String PADDING_NO = "NoPadding";

        public static byte[] encrypt(String content, String key,Charset  charset, Transform transform) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
            Cipher cipher = Cipher.getInstance(StringUtils.joinWith(transform.getDelimiter(), transform.getAlg(), transform.getMod(), transform.getPadding()));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(charset), transform.getAlg());
            if (MOD_CBC.equals(transform.getMod())) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(key.getBytes()));
            } else cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            return cipher.doFinal(content.getBytes(charset));
        }

        public static String encryptToBase64String(String content, String key,Charset charset, Transform transform) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
            byte[] encrypt = encrypt(content, key,charset, transform);
            return Base64.getEncoder().encodeToString(encrypt);
        }

        public static String decrypt(byte[] encryptBytes, String key,Charset charset, Transform transform) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
            Cipher cipher = Cipher.getInstance(StringUtils.joinWith(transform.getDelimiter(), transform.getAlg(), transform.getMod(), transform.getPadding()));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(charset), transform.getAlg());
            if (MOD_CBC.equals(transform.getMod())) {
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(key.getBytes()));
            } else cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(cipher.doFinal(encryptBytes),charset);
        }

        public static String decryptFromBase64String(String encryptBase64Str, String key,Charset charset, Transform transform) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
            byte[] decode = Base64.getDecoder().decode(encryptBase64Str);
            return decrypt(decode, key,charset, transform);
        }
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
