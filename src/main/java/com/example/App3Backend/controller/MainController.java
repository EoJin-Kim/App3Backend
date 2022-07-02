package com.example.App3Backend.controller;

import com.example.App3Backend.dto.*;
import com.example.App3Backend.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @PostMapping("/join_user")
    public String joinUser(String user_id,String user_pw,String user_nick_name) {

        System.out.println("user_id = " + user_id);
        System.out.println("user_pw = " + user_pw);
        System.out.println("user_nick_name = " + user_nick_name);
        mainService.joinUser(user_id,user_pw,user_nick_name);
//        System.out.println("request.getParameter(\"user_id\") = " + request.getParameter("user_id"));
        return "join";
    }

//    @PostMapping("/login_user")
//    public String loginUser(String user_id,String user_pw,Integer user_autologin){
//        Integer userIdx = mainService.login(user_id,user_pw);
//        if(userIdx==null) return "FAIL";
//        mainService.updateUser(userIdx,user_autologin);
//        return userIdx.toString();
//    }
    @PostMapping("/login_user")
    public String loginUser(LoginDto loginDto){
        Integer userIdx = mainService.login(loginDto.getUser_id(),loginDto.getUser_pw());
        if(userIdx==null) return "FAIL";
        mainService.updateUser(userIdx,loginDto.getUser_autologin());
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

    @PostMapping("/add_content")
    public ResponseEntity<?> addContent(CreateContentDto contentDto) throws IOException {

        String result = "";
        if(contentDto.getContent_image()==null || contentDto.getContent_image().isEmpty()){
            result = mainService.createContent(
                    contentDto.getContent_board_idx(), contentDto.getContent_writer_idx(), contentDto.getContent_subject(), contentDto.getContent_text(),null);
        }
        else {
            String filename = contentDto.getContent_image().getOriginalFilename();
            result = mainService.createContent(
                    contentDto.getContent_board_idx(), contentDto.getContent_writer_idx(), contentDto.getContent_subject(), contentDto.getContent_text(),filename);
            String fullPath = uploadPath + filename;
            System.out.println("fullPath = " + fullPath);
            contentDto.getContent_image().transferTo(new File(fullPath));
        }
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }

    @PostMapping("/get_content")
    public ResponseEntity<?> getContent(Integer read_content_idx){
        ContentDto contentDto = mainService.getContent(read_content_idx);
        return new ResponseEntity<ContentDto>(contentDto,HttpStatus.OK);
    }

    @PostMapping("/get_content_list")
    public ResponseEntity<?> getContentList(Integer content_board_idx){
        List<ContentSummary> contentList = mainService.getContentList(content_board_idx);

        return new ResponseEntity<List>(contentList,HttpStatus.OK);
    }


    @PostMapping("/delete_content")
    public ResponseEntity<?> deleteContent(Integer content_idx){
        mainService.deleteContent(content_idx);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("modify_content")
    public ResponseEntity<?> modifyContent(ModifyContentDto contentDto) throws IOException {
        mainService.modifyContent(contentDto);
        return new ResponseEntity(HttpStatus.OK);
    }


}
