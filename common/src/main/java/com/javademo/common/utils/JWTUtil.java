package com.javademo.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

public class JWTUtil {
    public static KeyPair getKeyPair(SignatureAlgorithm algorithm){
        return Keys.keyPairFor(algorithm);
    }
    public static String getToken(String username, long expireMills, SignatureAlgorithm algorithm, PrivateKey privateKey) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expireMills))
                .signWith(privateKey,algorithm)
                .compact();
    }
    public static Claims getClaims(String token, Key publicKey){
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token).getBody();
    }

    public static PrivateKey loadPrivateKey(byte[] keyBytes,SignatureAlgorithm algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance(algorithm.getFamilyName());
        return kf.generatePrivate(spec);
    }

    public static PublicKey loadPublicKey(byte[] keyBytes, SignatureAlgorithm algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance(algorithm.getFamilyName());
        return kf.generatePublic(spec);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPair keyPair = getKeyPair(SignatureAlgorithm.RS512);
        byte[] privateKey = keyPair.getPrivate().getEncoded();
        byte[] publicKey = keyPair.getPublic().getEncoded();
        String token = getToken("yan", 360000, SignatureAlgorithm.RS512, loadPrivateKey(privateKey,SignatureAlgorithm.RS512));
        Claims claims = getClaims(token,loadPublicKey(publicKey,SignatureAlgorithm.RS512));
        System.out.println(claims.getSubject());
    }
}
