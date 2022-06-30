package com.example.App3Backend.service;

import com.example.App3Backend.entity.UserTable;
import com.example.App3Backend.repository.MainCustomRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainCustomRepositoryImpl mainRepositoryImpl;

    public void joinUser(String user_id, String user_pw, String user_nick_name) {
        UserTable createUser = mainRepositoryImpl.createUser(user_id, user_pw, user_nick_name);
    }
}
