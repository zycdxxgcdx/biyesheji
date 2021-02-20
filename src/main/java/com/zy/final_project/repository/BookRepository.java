package com.zy.final_project.repository;

import com.zy.final_project.entity.Book;
import com.zy.final_project.entity.PublicPost;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//public interface BookRepository extends JpaRepository<Book,Integer> {
//}
@Repository
public interface BookRepository{
    public int findAllPages();
//    public List<Book> findAll(Integer page,Integer size);
//    public List<PublicPost> findAll(Integer page, Integer size);
    public List<String> findAll(Integer page, Integer size);
    public Book findById(Integer id);
    public void save(Book book);
    public void update(Book book);
    public void deleteById(Integer id);
}
