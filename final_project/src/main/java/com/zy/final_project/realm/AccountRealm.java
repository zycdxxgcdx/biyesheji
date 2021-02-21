package com.zy.final_project.realm;

import com.zy.final_project.repository.AccountRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.zy.final_project.entity.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm {

  @Autowired
  private AccountRepository accountRepository;
  /**
   * 授权
   * @param principalCollection
   * @return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //获取当前登录用户信息
    Subject subject = SecurityUtils.getSubject();
    Account account = (Account) subject.getPrincipal();

    //设置角色
    //Set集合防止重复
    Set<String> roles = new HashSet<>();
    roles.add(account.getRole());
    //SimpleAuthorizationInfo是AuthorizationInfo的子类
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

    //设置权限
    info.addStringPermission(account.getPerms());
    return info;
  }

  /**
   * 认证
   * @param authenticationToken
   * @return
   * @throws AuthenticationException
   */
//  客户端传来的用户名密码会直接封装到token里，然后根据用户名在数据库里进行查询，如果数据库返回null
//  直接return null；如何用户名存在，就将token里的密码和数据库里的密码比较
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    Account account = accountRepository.findByUsername(token.getUsername());
    if(account != null){
      return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
    }
    return null;
  }
}
