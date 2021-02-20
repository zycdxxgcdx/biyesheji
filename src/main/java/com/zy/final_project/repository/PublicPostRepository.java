package com.zy.final_project.repository;

import com.zy.final_project.entity.PublicPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicPostRepository {
  List<PublicPost> findAll(Integer page, Integer size);
  int findAllPages();
}
