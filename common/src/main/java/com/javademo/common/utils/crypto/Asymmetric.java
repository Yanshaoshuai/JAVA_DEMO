package com.javademo.common.utils.crypto;

import org.apache.tomcat.util.security.KeyStoreUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 非对称加密
 * A持有私钥
 * B持有公钥
 * A->B 对发送那内容做哈希获取摘要->对内容和摘要用私钥加密->B得到加密内容->解密获取摘要和内容->对内容哈希得到自己的摘要->对比从密文获取的摘要->二者一致则未被篡改
 * B->A  B对内容使用公钥加密->A对密文使用私钥解密
 *
 * 一般有两对密钥
 * A和B各自持有自己的私钥和对方的公钥
 *
 * Https 客户端和服务端用非对称加密协商绘会话密钥(协商之后各自持有的对称加密密钥相同) 之后用对称加密通信
 *todo ECC try-catch exception https
 */
public class Asymmetric {
    public Asymmetric() {
    }

    public static final String ALG_RSA = "RSA";
    public static final String ALG_ECC = "ECC";
    public static final String ALG_SIGNATURE_RSA = "SHA256WITHRSA";
    public static final String ALG_SIGNATURE_ECC = "SHA256WITHECC";

    public static KeyPair generateKeypair(String alg){
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return generator.generateKeyPair();
    }
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

    public static byte[] encrypt(String content, Charset charset, Key key, String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(content.getBytes(charset));
    }

    public static String encryptToBase64String(String content, Charset charset, Key key, String alg, boolean useRfc2045) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(content.getBytes(charset));
        return useRfc2045 ? Base64.getMimeEncoder().encodeToString(bytes) : Base64.getEncoder().encodeToString(bytes);
    }

    public static String decrypt(byte[] encryptBytes, Charset charset, Key key, String alg) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(encryptBytes), charset);
    }

    public static String decryptFromBase64String(String encryptBase64Str, Charset charset, Key key, String alg, boolean useRfc2045) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decode = useRfc2045 ? Base64.getMimeDecoder().decode(encryptBase64Str) : Base64.getDecoder().decode(encryptBase64Str);
        return decrypt(decode, charset, key, alg);
    }

    public static String getBase64Signature(String input,Charset charset,String alg,PrivateKey privateKey,boolean useRfc2045) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(alg);
        signature.initSign(privateKey);
        signature.update(input.getBytes(charset));
        byte[] sign = signature.sign();
        return useRfc2045?Base64.getMimeEncoder().encodeToString(sign):Base64.getEncoder().encodeToString(sign);
    }
    public static boolean verifyBase64Signature(String input,Charset charset,String alg,PublicKey publicKey,String base64Signature,boolean useRfc2045) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(alg);
        signature.initVerify(publicKey);
        signature.update(input.getBytes(charset));
        byte[] signatureBytes=useRfc2045?Base64.getMimeDecoder().decode(base64Signature.getBytes(charset)):Base64.getDecoder().decode(base64Signature.getBytes(charset));
        return signature.verify(signatureBytes);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        KeyPair keyPair = generateKeypair(ALG_RSA);
        String signature = getBase64Signature("aaa", Charset.defaultCharset(), ALG_SIGNATURE_RSA, keyPair.getPrivate(), true);
        System.out.println(signature);
        System.out.println(verifyBase64Signature("aaa",Charset.defaultCharset(),ALG_SIGNATURE_RSA,keyPair.getPublic(),signature,true));
    }
}