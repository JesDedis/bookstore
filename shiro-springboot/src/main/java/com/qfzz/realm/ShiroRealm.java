package com.qfzz.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //用户名
        String primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();

        //去数据库查询并判断  并分配权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("user:add");
        simpleAuthorizationInfo.addStringPermission("user:delete");
        //simpleAuthorizationInfo.addStringPermission("user:update");
        //simpleAuthorizationInfo.addStringPermission("user:query");

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //String username = (String) authenticationToken.getPrincipal();
        //Object password = authenticationToken.getCredentials();
        //String pwd = new String ((char[]) password);

        String username = "jack";
        String pwd = "123";

        //身份令牌  里面封装了用户名，密码，主机地址，rememberMe
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从身份令牌中取出用户名去和定义好的(数据库里的)用户名进行比较
        //shiro框架会自动帮我们比较密码，不用我们写
        if(!userToken.getUsername().equals(username)) {

            //SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username);

            return null; // 这里就会直接排除用户名异常，不需要我们特别说明
        }

        //密码认证 (因为密码认证程序员做很容易泄露，所以就直接交给shiro框架做~)
        //这里不需要我们传用户名，框架回自己去比对用户名和相应的密码
        return new SimpleAuthenticationInfo("",pwd,"");
    }
}
