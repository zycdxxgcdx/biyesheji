package com.zy.final_project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PublicPost {
  private String title;
  private String username;

//  @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone="GMT+8")
  private LocalDateTime postdate;

  private int views;
}
