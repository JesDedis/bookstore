package com.qf.config;

import com.qf.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {



    @Bean
    public ShiroRealm createShiroRealm() {
        return new ShiroRealm();
    }
    @Bean
    public DefaultWebSecurityManager createSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(createShiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(createSecurityManager());

        /*shiroFilterFactoryBean.setLoginUrl("/user/login");*/


        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        /*filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/fonts/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/layui/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/css-h/**","anon");

        filterChainDefinitionMap.put("/user/login","anon");
        filterChainDefinitionMap.put("/user/tologin","anon");
        filterChainDefinitionMap.put("/user/register","anon");
        filterChainDefinitionMap.put("/user/toregister","anon");
        filterChainDefinitionMap.put("/admin/index","anon");
        filterChainDefinitionMap.put("/admin/login","anon");

        filterChainDefinitionMap.put("/user/logout","logout");
        filterChainDefinitionMap.put("/admin/exit","logout");*/

        /*filterChainDefinitionMap.put("/**","authc");*/
        filterChainDefinitionMap.put("/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
