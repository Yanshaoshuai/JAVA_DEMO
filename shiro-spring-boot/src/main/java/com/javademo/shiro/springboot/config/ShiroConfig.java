package com.javademo.shiro.springboot.config;

import com.javademo.shiro.springboot.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    private MyRealm myRealm;

    public ShiroConfig(MyRealm myRealm) {
        this.myRealm = myRealm;
    }

    /**
     * 创建defaultWebSecurityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        //1.创建defaultWebSecurityManager
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //2.创建加密对象 设置相关属性
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置算法
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置迭代加密次数
        credentialsMatcher.setHashIterations(3);
        //3.将加密对象存储到realm中
        myRealm.setCredentialsMatcher(credentialsMatcher);
        //4.将realm设置到创建defaultWebSecurityManager中
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 设置shiro过滤器拦截范围
     */
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition=new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/shiro/userLogin","anon");
        definition.addPathDefinition("/shiro/login","anon");
        definition.addPathDefinition("/**","authc");
        return definition;
    }
}
