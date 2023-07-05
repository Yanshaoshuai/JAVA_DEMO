package com.javademo.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {
    private final static Logger LOG = LoggerFactory.getLogger(ShiroTest.class);
    @Test
    public void testShiroIni(){
        //1.获取SecurityManager
        IniSecurityManagerFactory securityManagerFactory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //2.获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //3.创建token对象,由客户端传递
        AuthenticationToken token=new UsernamePasswordToken("zhangsan","z3");
        try {
            //4.登录
            subject.login(token);
            LOG.info("login success");
        }catch (Exception e){
            LOG.error("login failed",e);
        }
        //5.判断角色(角色是权限的集合)
        boolean admin = subject.hasRole("admin");
        LOG.info("is admin? {}",admin);
        //6.判断权限
        boolean permitted = subject.isPermitted("user:delete");
        LOG.info("has user:delete permission? {}",permitted);
        //没有返回值，没有权限会抛异常
        //subject.checkPermission("user:remove");
    }
    @Test
    public void testShiroEncrypt(){
        String password= "123";
        Md5Hash md5Hash=new Md5Hash(password);
        LOG.info("md5 password string {}",md5Hash.toHex());
        //带盐的md5加密就是在字符串后面再拼接一段字符串然后再加密
        Md5Hash md5=new Md5Hash(password,"salt");
        LOG.info("md5 with salt password string {}",md5.toHex());
        //为了密码安全 可以多次md5迭代加密
        Md5Hash md5Multi=new Md5Hash(password,"salt",3);
        LOG.info("md5 multi with salt password string {}",md5Multi.toHex());

        //使用其他方式加密
        SimpleHash simpleHash=new SimpleHash("MD5",password,"salt",3);
        LOG.info("simpleHash multi with salt password string {}",simpleHash.toHex());
    }
    @Test
    public void testCustomRealm(){
        IniSecurityManagerFactory securityManagerFactory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken("yan","123456");
        try{
            subject.login(token);
            LOG.info("login success");
        }catch (Exception e){
            LOG.error("login failed",e);
        }

    }
}
