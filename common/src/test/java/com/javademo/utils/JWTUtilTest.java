package com.javademo.utils;

import com.javademo.common.utils.CryptoUtil;
import com.javademo.common.utils.JWTUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public class JWTUtilTest {
    private final static Logger LOG = LoggerFactory.getLogger(JWTUtilTest.class);

    @Test
    public void usage() {
        KeyPair keyPair = JWTUtil.getKeyPair(SignatureAlgorithm.ES512);
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        try {
            PrivateKey privateKey = CryptoUtil.loadPrivateKey(privateKeyBytes, SignatureAlgorithm.ES512.getFamilyName());
            PublicKey publicKey = CryptoUtil.loadPublicKey(publicKeyBytes, SignatureAlgorithm.ES512.getFamilyName());
            String token  = JWTUtil.getToken("yan", 360000, SignatureAlgorithm.ES512,privateKey );
            LOG.info("header is {}", JWTUtil.getHeader(token,publicKey));
            LOG.info("body is {}", JWTUtil.getBody(token, publicKey));
            LOG.info("signature is {}", JWTUtil.getSignature(token,publicKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
