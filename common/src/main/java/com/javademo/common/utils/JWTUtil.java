package com.javademo.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

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
    public static Jws<Claims> getClaims(String token, PublicKey publicKey){
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token);
    }

    public static Header getHeader(String token, PublicKey publicKey){
        Jws<Claims> claims = getClaims(token, publicKey);
        return claims.getHeader();
    }

    public static Claims getBody(String token, PublicKey publicKey){
        Jws<Claims> claims = getClaims(token, publicKey);
        return claims.getBody();
    }

    public static String getSignature(String token, PublicKey publicKey){
        Jws<Claims> claims = getClaims(token, publicKey);
        return claims.getSignature();
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
}
