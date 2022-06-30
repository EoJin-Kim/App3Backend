package com.example.App3Backend.controller;

import com.example.App3Backend.dto.JoinDto;
import com.example.App3Backend.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
}
