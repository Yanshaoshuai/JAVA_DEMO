package com.javademo.utils;

import com.javademo.common.pojo.Transform;
import com.javademo.common.utils.crypto.Asymmetric;
import com.javademo.common.utils.crypto.Digest;
import com.javademo.common.utils.crypto.Symmetric;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CryptoUtilTest {


    private final static Logger LOG = LoggerFactory.getLogger(CryptoUtilTest.class);

    /**
     * 散列函数 哈希 消息摘要
     * 保证文件或者值的安全
     * 不可逆
     * MD5
     * SHA1
     * SHA256
     * SHA512
     */
    @Test
    public void testMessageDigest() {
        List<String> algList = List.of("MD5", "SHA1", "SHA256", "SHA512");
        String content = "12345678";
        MessageDigest digest = null;
        for (String alg : algList) {
            try {
                LOG.info("-----alg {} start------", alg);
                digest = MessageDigest.getInstance(alg);
                byte[] digestBytes = digest.digest(content.getBytes());
                String hex = Digest.toHexZeroPadding(digestBytes);
                LOG.info("result {}", hex);
                LOG.info("-----alg {} start------", alg);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * 对称加密
     * DES Data Encryption Standard 数据加密标准
     * AES Advanced Encryption Standard 高级加密标准
     * 加密解密使用同一密钥--流加密(每个元素作为加密单元)/块加密(先分块,再以块为单位加密)
     * DES明文必须是8字节正数倍 AES明文必须是16字节整数倍
     */
    @Test
    public void testSymmetric() {
        String content = "0123456701234567";

        Map<Transform, String> transformationKeyMap =
                Map.of(new Transform(Symmetric.ALG_DES, Symmetric.MOD_ECB, Symmetric.PADDING_PKCS5, "/"), "12345678",
                        new Transform(Symmetric.ALG_DES, Symmetric.MOD_CBC, Symmetric.PADDING_PKCS5, "/"), "12345678",
                        new Transform("DES", "ECB", "NoPadding", "/"), "12345678",
                        new Transform("DES/CBC/NoPadding", "/"), "12345678",

                        new Transform("AES/ECB/PKCS5Padding", "/"), "1234567812345678",
                        new Transform("AES/CBC/PKCS5Padding", "/"), "1234567812345678",
                        new Transform(Symmetric.ALG_AES, Symmetric.MOD_CBC, Symmetric.PADDING_NO, "/"), "1234567812345678",
                        new Transform(Symmetric.ALG_AES, Symmetric.MOD_CBC, Symmetric.PADDING_NO, "/"), "1234567812345678");
        for (Map.Entry<Transform, String> entry : transformationKeyMap.entrySet()) {
            String key = entry.getValue();
            Transform transform = entry.getKey();
            LOG.info("----------{} started-------", transform.getTransformation());
            String encryptBase64String = Symmetric.encryptToBase64String(content, key, Charset.defaultCharset(), transform);
            LOG.info("encode bytes base64 string {}", encryptBase64String);

            String decryptContent = Symmetric.decryptFromBase64String(encryptBase64String, key, Charset.defaultCharset(), transform);
            LOG.info("decode content is {}", decryptContent);
            LOG.info("----------{} end-------", transform.getTransformation());

        }
    }

    /**
     * 非对称加密
     * 必须要有两个(一对)密钥
     * 使用公钥加密必须用私钥解密
     * 使用私钥加密必须用公钥解密
     * 常见算法 RSA ECC
     */
    @Test
    public void testAsymmetric() throws RuntimeException {
        String alg = "RSA";
        String content = "12345678";
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(alg);
            KeyPair keyPair = generator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            //获取私钥字节数组
            byte[] privateKeyEncoded = privateKey.getEncoded();
            PublicKey publicKey = keyPair.getPublic();
            //获取公钥字节数组
            byte[] publicKeyEncoded = publicKey.getEncoded();

            //获取Base64字符串
            //getMimeEncoder获取的encoder会换行
            Base64.Encoder encoder = Base64.getMimeEncoder();
            Base64.Decoder decoder = Base64.getDecoder();
            String privateKeyBase64Str = encoder.encodeToString(privateKeyEncoded);
            String publicKeyBase64Str = encoder.encodeToString(publicKeyEncoded);
            LOG.info("privateKeyBase64Str {}", privateKeyBase64Str);
            LOG.info("publicKeyBase64Str {}", publicKeyBase64Str);

            //私钥加密 公钥解密
            Cipher cipher = Cipher.getInstance(alg);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] encryptByPrivateKeyBytes = cipher.doFinal(content.getBytes());
            LOG.info("encryptByPrivateKeyBytes Base64 string {}", encoder.encodeToString(encryptByPrivateKeyBytes));
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] decryptByPublicKeyBytes = cipher.doFinal(encryptByPrivateKeyBytes);
            LOG.info(new String(decryptByPublicKeyBytes));

            //公钥加密 私钥解密
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptByPublicKeyBytes = cipher.doFinal(content.getBytes());
            LOG.info("encryptByPublicKeyBytes Base64 string {}", encoder.encodeToString(encryptByPublicKeyBytes));
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptByPrivateKeyBytes = cipher.doFinal(encryptByPublicKeyBytes);
            LOG.info(new String(decryptByPrivateKeyBytes));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException(e);
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
    @Test
    public void testSignature() {
        KeyPair keyPair = Asymmetric.generateKeypair(Asymmetric.ALG_RSA);
        String signature = Asymmetric.getBase64Signature("aaa", Charset.defaultCharset(), Asymmetric.ALG_SIGNATURE_RSA, keyPair.getPrivate(), true);

        LOG.info("---signature is {}---", signature);
        LOG.info("---verify result is {}---", Asymmetric.verifyBase64Signature("aaa", Charset.defaultCharset(), Asymmetric.ALG_SIGNATURE_RSA, keyPair.getPublic(), signature, true));

    }

    @Test
    public void keystoreTest() {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(new FileInputStream("C:\\Users\\yan\\.keystore"), "123456".toCharArray());
            Enumeration<String> aliases = instance.aliases();
            Iterator<String> stringIterator = aliases.asIterator();
            while (stringIterator.hasNext()) {
                System.out.println(stringIterator.next());
            }
            //获取PrivateKeyEntry
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) instance.getEntry("mykey", new KeyStore.PasswordProtection("123456".toCharArray()));

            //获取私钥
            PrivateKey privateKey = privateKeyEntry.getPrivateKey();
            LOG.info(privateKey.getAlgorithm());
            //获取证书
            Certificate certificate = privateKeyEntry.getCertificate();
            String type = certificate.getType();
            LOG.info(type);
            X509Certificate x509Certificate = (X509Certificate) certificate;
            String sigAlgName = x509Certificate.getSigAlgName();
            LOG.info(sigAlgName);
            LOG.info("{}", x509Certificate.getVersion());
            LOG.info("{}", x509Certificate.getSignature());
            //获取公钥
            PublicKey publicKey = certificate.getPublicKey();
            String algorithm1 = publicKey.getAlgorithm();
            LOG.info(algorithm1);

        } catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException |
                 UnrecoverableEntryException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOUubn4qizJtpx+n".length());
    }
}
