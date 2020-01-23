package com.qfzz.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qfzz.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration//没有添加配置注解的话就会输入账号密码输入后登陆不了
public class ShiroConfig {

    //记住我 RememberMe 的配置
    public CookieRememberMeManager createCookieRememberMeManager() {

        SimpleCookie simpleCookie = new SimpleCookie();
        //*搞清楚为什么不设置Cookie的名字就会报错让我们设置名字？*
        simpleCookie.setName("rememberMe");
        simpleCookie.setMaxAge(50000);//设置有效时间

        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);

        return cookieRememberMeManager;
    }

    @Bean
    public ShiroDialect createShiroDialect() {

        return new ShiroDialect();
    }

    //创建Realm
    @Bean
    public ShiroRealm createShiroRealm() {

        ShiroRealm shiroRealm = new ShiroRealm();

        return shiroRealm;
    }

    //创建SecurityManger
    @Bean
    public DefaultWebSecurityManager createSecurityManger(ShiroRealm shiroRealm) {

        /**
         * DefaultWebSecurityManager 继承了 DefaultSecurityManager类
         * 实现了 WebSecurityManager接口
         * 而 WebSecurityManager 接口 继承了 SecurityManager
         * 从而达到了创建 SecurityManager 工厂时直接写 SecurityManager 类的有时候下载不了包的问题
         */
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);//引入Realm

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean ShiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {

        /*
            shiro有以下几种过滤器：
            1. anon： 无需认证就可以访问的
            2. authc： 必须认证了才能访问
            3. user： 必须拥有 记住我 功能才能访问
            4. perms： 必须拥有权限才能访问
            5. role： 必须拥有角色才能访问
         */

        //Shiro过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //引入安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //未认证跳转登陆界面   点相应的连接就会直接跳到登陆界面登陆
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        //设置未授权登录界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/refuse");
        //有顺序map集合
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        //可以匿名访问  就是可以不用登陆授权就能访问信息
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/css/**","anon");

        linkedHashMap.put("/user/login","anon");

        //设置权限访问路径
        linkedHashMap.put("/user/add","perms[user:add]");

        //loginout
        linkedHashMap.put("/user/loginout","logout");

        //配置RememberMe的访问路径
        linkedHashMap.put("/user/index","user");

        //需要认证才能访问
        linkedHashMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);

        return shiroFilterFactoryBean;
    }

}
