package com.javademo.shiro.springboot.realm;

import com.javademo.shiro.springboot.entity.User;
import com.javademo.shiro.springboot.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {

    private UserService userService;

    public MyRealm(UserService userService) {
        this.userService = userService;
    }

    /**
     * 自定义授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = token.getPrincipal().toString();
        User userInfoByName = userService.getUserInfoByName(name);
        if(userInfoByName!=null){
            return new SimpleAuthenticationInfo(token.getPrincipal(),userInfoByName.getPwd(), ByteSource.Util.bytes("salt"),name);
        }
        return null;
    }
}
