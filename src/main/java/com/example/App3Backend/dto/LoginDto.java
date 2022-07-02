package com.example.App3Backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    String user_id;
    String user_pw;
    Integer user_autologin;
}
