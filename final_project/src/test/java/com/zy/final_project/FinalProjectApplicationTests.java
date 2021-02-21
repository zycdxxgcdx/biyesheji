package com.zy.final_project;

import com.zy.final_project.entity.Book;
import com.zy.final_project.repository.BookRepository;
import com.zy.final_project.repository.PublicPostRepository;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.zy.final_project.repository")
class FinalProjectApplicationTests {
    @Autowired
    private BookRepository repository;

    @Autowired
    private PublicPostRepository publicPostRepository;

    @Test
    void findAllPagess(){
        System.out.println(publicPostRepository.findAllPages());
    }

//    @Test
//    void findAllPagesss(){
//        System.out.println(publicPostRepository.findAll());
//    }

    @Test
    void contextLoads() {
    }

    @Test
    void findAll(){
        System.out.println(repository.findAll(1,6));
    }

    @Test
    void findAllPages(){
        System.out.println(repository.findAllPages());
    }

//    @Test
//    void save(){
//        Book book = new Book();
//        book.setName("Spring boot");
//        book.setAuthor("张三");
//        Book book1 = repository.save(book);
//        System.out.println(book1);
//    }
//
//    @Test
//    void findById(){
//        Book book = repository.findById(1).get(); // findById返回的是Option对象，get方法拿到book对象
//        System.out.println(book);
//    }
//
//    @Test
//    void udpate(){
//        Book book = new Book();
//        book.setId(20);
//        book.setName("测试测试");
//        Book boo1 = repository.save(book);
//        System.out.println(boo1);
//    }
//
//    @Test
//    void delete(){
//        repository.deleteById(20);
//    }

}
