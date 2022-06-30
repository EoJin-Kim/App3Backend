package com.example.App3Backend.util;

import com.example.App3Backend.repository.MainCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class InitDB {

    private final InitService initService;


    @PostConstruct
    public void init() {
        initService.dbInit();

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final MainCustomRepository mainCustomRepository;

        public void dbInit() {
            initBoardTable();
            initUser();
        }

        private void initUser() {
            mainCustomRepository.createUser("test","test","test");
        }

        private void initBoardTable() {
            System.out.println("DB INIT");

        }
    }
}
