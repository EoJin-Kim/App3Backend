package com.example.App3Backend.controller;

import com.example.App3Backend.dto.BoardDto;
import com.example.App3Backend.dto.JoinDto;
import com.example.App3Backend.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping("/join_user")
    public String joinUser(String user_id,String user_pw,String user_nick_name) {

        System.out.println("user_id = " + user_id);
        System.out.println("user_pw = " + user_pw);
        System.out.println("user_nick_name = " + user_nick_name);
        mainService.joinUser(user_id,user_pw,user_nick_name);
//        System.out.println("request.getParameter(\"user_id\") = " + request.getParameter("user_id"));
        return "join";
    }

    @PostMapping("/login_user")
    public String loginUser(String user_id,String user_pw,Integer user_autologin){
        Integer userIdx = mainService.login(user_id,user_pw);
        if(userIdx==null) return "FAIL";
        mainService.updateUser(userIdx,user_autologin);
        return userIdx.toString();
    }

    @PostMapping("/check_auto_login")
    public String checkAutoLogin(String login_user_idx){
        Integer chk = mainService.checkAutoLogin(login_user_idx);
        System.out.println(chk);
        return chk.toString();
    }

    @GetMapping("/get_board_list")
    public ResponseEntity<?> getBoardList() {
        List<BoardDto> boardList = mainService.getBoardList();

        return new ResponseEntity<List>(boardList, HttpStatus.OK);
    }



}
