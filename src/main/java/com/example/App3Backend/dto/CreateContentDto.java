package com.example.App3Backend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CreateContentDto {
    Integer content_board_idx;
    Integer content_writer_idx;
    String content_subject;
    String content_text;
    MultipartFile content_image;
}
