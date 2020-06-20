package com.bdqn.erp.config;

import com.bdqn.erp.cache.RedisCacheManager;
import com.bdqn.erp.utils.Myrealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public Myrealm myrealm(){
        Myrealm myrealm=new Myrealm();
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(2);
        myrealm.setCredentialsMatcher(matcher);
        myrealm.setCacheManager(new RedisCacheManager());
        myrealm.setAuthorizationCachingEnabled(true);
        myrealm.setAuthorizationCacheName("authorizationCache");
        return myrealm;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myrealm());
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String,String> map =new LinkedHashMap<>();
         map.put("/resources/**","anon");
         map.put("/erp/user/login","anon");
         map.put("/login","anon");
         map.put("/swagger-ui.html","anon");
         map.put("/","anon");
         map.put("/login.html","anon");
         map.put("/favicon.ico","anon");
         map.put("/logout","logout");
         map.put("/**","authc");
         shiroFilterFactoryBean.setLoginUrl("/login");
         shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
}
