package com.example.App3Backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinDto {
    public String user_id;
    public String user_pw;
    public String user_nick_name;
}
