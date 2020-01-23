package com.qfzz.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class AuthenticationDemo {

    @Test
    public void login(){
        //工厂
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建securityManager对象
        SecurityManager securityManager = factory.getInstance();
        //加载
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken("Jackeylove","123");
        //认证
        try {
            // 执行认证提交   ctrl+Alt+t是添加try+catch块
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //进行认证
        boolean authenticated1 = subject.isAuthenticated();

        System.out.println("认证结果：" + authenticated1);

        subject.logout();

        boolean authenticated2 = subject.isAuthenticated();

        System.out.println("认证结果：" + authenticated2);
    }


    @Test
    public void myRealm(){
        //工厂
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:myRealm.ini");
        //创建securityManager对象
        SecurityManager securityManager = factory.getInstance();
        //加载
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken("Mayumi","456");
        //认证
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //进行认证
        boolean authenticated1 = subject.isAuthenticated();

        System.out.println("认证结果："+authenticated1);

    }

}
