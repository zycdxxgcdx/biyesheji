package com.zy.final_project.controller;

import com.zy.final_project.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class AccountController {

  @GetMapping("/{url}")
  public String redirect(@PathVariable("url") String url){
    return url;
  }

  //登录验证
  @PostMapping("/login")
  public String login(@RequestBody Account account){
    String username = account.getUsername();
    String password = account.getPassword();
    System.out.println(username);
    System.out.println(password);
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    try{
      //登录成功
      subject.login(token);
      return "success";
    }catch (UnknownAccountException e){
      //用户名不存在
      return "unknownaccount";
    }catch (IncorrectCredentialsException e){
      //密码异常111
      return "incorrectpassword";
    }
  }

  @GetMapping("/unauth")
  @ResponseBody
  public String unauth(){
    return "未授权，无法访问";
  }

  //账号退出
  @GetMapping("/logout")
  public String logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return "login";
  }
}
