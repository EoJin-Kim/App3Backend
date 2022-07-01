package com.example.App3Backend.util;

import com.example.App3Backend.entity.BoardTable;
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
            BoardTable board1 = mainCustomRepository.createBoard("게시판1");
            BoardTable board2 = mainCustomRepository.createBoard("게시판2");
            BoardTable board3 = mainCustomRepository.createBoard("게시판3");
            BoardTable board4 = mainCustomRepository.createBoard("게시판4");

            System.out.println("DB INIT");

        }
    }
}
