package com.example.App3Backend.repository;

import com.example.App3Backend.entity.BoardTable;
import com.example.App3Backend.entity.ContentTable;
import com.example.App3Backend.entity.UserTable;

import java.util.List;

public interface MainCustomRepository {
    UserTable createUser(String user_id, String user_pw, String user_nick_name);

    UserTable findUser(String user_id, String user_pw);

    void updateUser(Integer userIdx, Integer user_autologin);

    Integer checkAutoLogin(Integer userIdx);

    BoardTable createBoard(String board);

    List<BoardTable> getBoardList();

    BoardTable findBoardByIdx(Integer content_board_idx);

    UserTable findUserByIdx(Integer content_writer_idx);

}
