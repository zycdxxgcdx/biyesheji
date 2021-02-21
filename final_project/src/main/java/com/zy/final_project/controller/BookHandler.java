package com.zy.final_project.controller;

import com.zy.final_project.entity.Account;
import com.zy.final_project.entity.Book;
import com.zy.final_project.entity.PublicPost;
import com.zy.final_project.repository.BookRepository;
import com.zy.final_project.repository.PublicPostRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/main")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublicPostRepository publicPost;

//    @GetMapping("/findAllPages")
//    public int findAllPages(){
//        return bookRepository.findAllPages();
//    }

    //主页查询全部帖子接口
    @GetMapping("/findAllPages")
    public int findAllPages(){
        return publicPost.findAllPages();
    }

    //主页分页查询接口
    @GetMapping("/findAll/{page}/{size}")
    public List<PublicPost> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return publicPost.findAll((page-1)*size,size);
    }
//    public List<Book> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
//        return bookRepository.findAll((page-1)*size,size);
//    }
//    @GetMapping("/findAll/{id}")
//    public Book findAll(@PathVariable("id") Integer id){
//        return bookRepository.findById(id);
//    }

//    @GetMapping("/findAll/{page}/{size}")
//    public Page<Book> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
//        //return bookRepository.findAll();
//        Pageable pageable = PageRequest.of(page-1,size);
//        return bookRepository.findAll(pageable);
//    }
//    @PostMapping("/save")
//    public String save(@RequestBody Book book){
//        Book result = bookRepository.save(book);
//        if(result!=null){
//            return "success";
//        }else{
//            return "error";
//        }
//    }
//
//    @GetMapping("/findById/{id}")
//    public Book findById(@PathVariable("id") Integer id){
//        return bookRepository.findById(id).get();
//    }
//
//    @PutMapping("/update")
//    public String update(@RequestBody Book book){
//        Book result = bookRepository.save(book);
//        if(result!=null){
//            return "success";
//        }else{
//            return "error";
//        }
//    }
//
//    @DeleteMapping("/deleteById/{id}")
//    public void delete(@PathVariable("id") Integer id){
//        bookRepository.deleteById(id);
//    }
}
