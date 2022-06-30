package com.example.App3Backend.util;

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

        public void dbInit() {
            initBoardTable();
        }

        private void initBoardTable() {
            System.out.println("DB INIT");
        }
    }
}
