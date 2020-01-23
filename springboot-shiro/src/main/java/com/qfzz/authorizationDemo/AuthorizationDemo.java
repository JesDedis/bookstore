package com.qfzz.authorizationDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

public class AuthorizationDemo {

    //角色授权,资源授权测试
    @Test
    public void testAuthorization(){

        //工厂
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:permission.ini");
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
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //进行认证
        boolean authenticated1 = subject.isAuthenticated();

        System.out.println("认证结果：" + authenticated1);

        //认证通过进行授权
        if(authenticated1) {

            //基于角色
            //判断单个角色
            boolean role1 = subject.hasRole("role1");
            System.out.println("单个角色:" + role1);

            //判断多个角色
            boolean roles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
            System.out.println("多个角色:" + roles);

            System.out.println("---------------------------------------------");

            //基于资源
            //判断单个资源
            boolean permitted = subject.isPermitted("user:add");
            System.out.println("单个资源:" + permitted);

            //判断多个资源
            boolean permitteds = subject.isPermittedAll("user:add","user:delete");
            System.out.println("多个资源:" + permitteds);

            //check：没有指定角色或者权限会报错
            subject.checkRole("role1");
            System.out.println("=========");
            //subject.checkPermission("user:delete");
        }
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

        System.out.println("认证结果：" + authenticated1);
        System.out.println("---------------------+++------------------------");

        //基于角色
        //判断单个角色
        //boolean role1 = subject.hasRole("role1");
        //System.out.println("单个角色:"+role1);

        //判断多个角色
        //boolean roles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
        //System.out.println("多个角色:"+roles);

        System.out.println("---------------------------------------------");

        //基于资源
        //判断单个资源
        boolean permitted = subject.isPermitted("user:add");
        System.out.println("单个资源:" + permitted);

        //判断多个资源
        boolean permitteds = subject.isPermittedAll("user:add","user:delete");
        System.out.println("多个资源:" + permitteds);

    }
}