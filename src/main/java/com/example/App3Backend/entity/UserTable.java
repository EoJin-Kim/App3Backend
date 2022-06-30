package com.example.App3Backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class UserTable {

    @Id
    @GeneratedValue
    Integer userIdx;
    String userId;
    String userPw;
    Integer userAutologin;
    String userNickNake;

    public static UserTable createUser(String user_id, String user_pw, int i, String user_nick_name) {
        UserTable user = new UserTable();
        user.setUserId(user_id);
        user.setUserPw(user_pw);
        user.setUserAutologin(i);
        user.setUserNickNake(user_nick_name);
        return user;
    }
}
