package com.example.App3Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserTable {

    @Id
    @GeneratedValue
    Integer userIdx;
    String userId;
    String userPw;
    Boolean userAutologin;
    String userNickNake;
}
