package com.example.App3Backend.service;

import com.example.App3Backend.dto.BoardDto;
import com.example.App3Backend.entity.BoardTable;
import com.example.App3Backend.entity.UserTable;
import com.example.App3Backend.repository.MainCustomRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainCustomRepositoryImpl mainRepositoryImpl;

    public void joinUser(String user_id, String user_pw, String user_nick_name) {
        UserTable createUser = mainRepositoryImpl.createUser(user_id, user_pw, user_nick_name);
    }

    public Integer login(String user_id, String user_pw) {
        UserTable findUser = mainRepositoryImpl.findUser(user_id,user_pw);
        if(findUser==null){
            return null;
        }
        return findUser.getUserIdx();
    }

    public void updateUser(Integer userIdx, Integer user_autologin) {
        mainRepositoryImpl.updateUser(userIdx,user_autologin);
    }

    public Integer checkAutoLogin(String userIdx) {
        Integer chk = mainRepositoryImpl.checkAutoLogin(Integer.valueOf(userIdx));
        return chk;
    }

    public List<BoardDto> getBoardList() {
        List<BoardTable> boardList = mainRepositoryImpl.getBoardList();
        List<BoardDto> result = boardList.stream().map(bt -> new BoardDto(bt.getBoardIdx().toString(), bt.getBoardName())).collect(Collectors.toList());
        return result;
    }
}
