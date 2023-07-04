package com.javademo.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 需要在ini文件中配置生效
 */
public class MyRealm extends AuthenticatingRealm {
    private final static Logger LOG = LoggerFactory.getLogger(MyRealm.class);


    /**
     * 自定义登录认证方法
     * 通过token获取系统中对应的认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取身份信息
        String principal = token.getPrincipal().toString();
        //2.获取凭证信息
        String password = new String((char[]) token.getCredentials());
        LOG.info("principal {} password {}", principal, password);
        //3.获取数据库中存储的用户信息
        //todo 从数据库获取用户信息
        if (principal.equals("yan")) {
            //4.封装校验逻辑对象
            String actualPwd = "d1b129656359e35e95ebd56a63d7b9e0";
            return new SimpleAuthenticationInfo(token.getPrincipal(), actualPwd,
                    ByteSource.Util.bytes("salt"), token.getPrincipal().toString());
        }
        return null;
    }
}
