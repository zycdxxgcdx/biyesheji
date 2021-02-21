package com.zy.final_project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {
  @Autowired
  private AccountRepository accountRepository;
  @Test
  void findByUsername() {
    System.out.println(accountRepository.findByUsername("zs"));
  }
}