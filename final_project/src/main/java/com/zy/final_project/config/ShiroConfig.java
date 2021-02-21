package com.zy.final_project.config;

import com.zy.final_project.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro配置
 * 将realm加载进shiro中
 */
@Configuration
public class ShiroConfig {

  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager){
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
    factoryBean.setSecurityManager(securityManager);
    //权限设置
    Map<String,String> map = new HashMap<>();
//    map.put("/main","authc");
//    map.put("/manage","perms[manage]");
//    map.put("/administrator","roles[administrator]");
    factoryBean.setFilterChainDefinitionMap(map);
    //设置登录页面
    //未登录自动跳转到该页面，如果被拦截了的话
//    factoryBean.setLoginUrl("/login");
    //设置未授权页面
//    factoryBean.setUnauthorizedUrl("/unauth");
    return factoryBean;
  }

  //注入到上面的方法中
  //@Qualifier 指定注入的容器名 就是下面方法中的bean，一般是方法名
  @Bean
  public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
    manager.setRealm(accountRealm);
    return manager;
  }

  //注入到上面的方法中
  @Bean
  public AccountRealm accountRealm(){
    return new AccountRealm();
  }
}
