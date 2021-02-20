package com.zy.final_project.repository;

import com.zy.final_project.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
  Account findByUsername(String username);
}
