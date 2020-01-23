package com.qfzz.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.HashSet;

public class realmDemo extends AuthorizingRealm {

    private String realmName = "realmDemo";

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从token中取出信息
        //用户名,身份信息
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println(principal);

        //密码,凭证
        //这里不能强转成String，如果强转返回的会显示不出结果
        Object credentials = authenticationToken.getCredentials();

        //类型转化
        String password = new String((char[]) credentials);
        System.out.println(password);

        if("Jackeylove".equals(principal)  &&  "b106dc6352e5ec1f8aafd8c406d34d92".equals(password)){

            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(principal,password,realmName);

            return simpleAuthenticationInfo;
        }
        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取用户名
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("primaryPrincipal:" + primaryPrincipal);

        //连接数据库进行查询
        //基于角色授权   因为角色会有很多所有就要用ArrayList进行装配,并添加
        ArrayList<String> roles = new ArrayList<>();
        roles.add("role1");
        roles.add("role2");

        //基于资源
        HashSet<String> permissions = new HashSet<>();
        permissions.add("user:add");
        permissions.add("user:update");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

}
