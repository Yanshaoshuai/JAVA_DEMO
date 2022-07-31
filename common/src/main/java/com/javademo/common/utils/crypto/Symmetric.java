package com.javademo.common.utils.crypto;

import com.javademo.common.pojo.Transform;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Symmetric {
    public Symmetric() {
    }

    public static final String ALG_DES = "DES";
    public static final String ALG_AES = "AES";
    public static final String MOD_CBC = "CBC";
    public static final String MOD_ECB = "ECB";
    public static final String PADDING_PKCS5 = "PKCS5Padding";
    public static final String PADDING_NO = "NoPadding";

    public static byte[] encrypt(String content, String key, Charset charset, Transform transform) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(StringUtils.joinWith(transform.getDelimiter(), transform.getAlg(), transform.getMod(), transform.getPadding()));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(charset), transform.getAlg());
            if (MOD_CBC.equals(transform.getMod())) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(key.getBytes()));
            } else cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            return cipher.doFinal(content.getBytes(charset));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException |
                 IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    public static String encryptToBase64String(String content, String key, Charset charset, Transform transform) {
        byte[] encrypt = encrypt(content, key, charset, transform);
        return Base64.getEncoder().encodeToString(encrypt);
    }

    public static String decrypt(byte[] encryptBytes, String key, Charset charset, Transform transform) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(StringUtils.joinWith(transform.getDelimiter(), transform.getAlg(), transform.getMod(), transform.getPadding()));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(charset), transform.getAlg());
            if (MOD_CBC.equals(transform.getMod())) {
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(key.getBytes()));
            } else cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(cipher.doFinal(encryptBytes), charset);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException |
                 IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    public static String decryptFromBase64String(String encryptBase64Str, String key, Charset charset, Transform transform) {
        byte[] decode = Base64.getDecoder().decode(encryptBase64Str);
        return decrypt(decode, key, charset, transform);
    }
}
