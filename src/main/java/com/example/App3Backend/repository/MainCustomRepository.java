package com.example.App3Backend.repository;

import com.example.App3Backend.entity.UserTable;

public interface MainCustomRepository {
    UserTable createUser(String user_id, String user_pw, String user_nick_name);

    UserTable findUser(String user_id, String user_pw);

    void updateUser(Integer userIdx, Integer user_autologin);

    Integer checkAutoLogin(Integer userIdx);
}
