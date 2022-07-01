package com.example.App3Backend.dto;

import com.example.App3Backend.entity.ContentTable;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
public class ContentDto {
    String content_nick_name;
    String content_subject;
    String content_text;
    String content_image;
    String content_write_date;

    public static ContentDto create(ContentTable content) {
        ContentDto contentDto = new ContentDto();
        contentDto.setContent_nick_name(content.getUserTable().getUserNickNake());
        contentDto.setContent_subject(content.getContentSubject());
        contentDto.setContent_text(content.getContentText());
        contentDto.setContent_image(content.getContentImage());
        contentDto.setContent_write_date(content.getCotentWriteDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
        return contentDto;

    }
}
