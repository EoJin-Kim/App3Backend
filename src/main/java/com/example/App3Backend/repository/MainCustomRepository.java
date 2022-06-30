package com.example.App3Backend.repository;

import com.example.App3Backend.entity.UserTable;

public interface MainCustomRepository {
    public UserTable createUser(String user_id, String user_pw, String user_nick_name);
}
