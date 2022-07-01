package com.example.App3Backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ContentTable {

    @Id
    @GeneratedValue
    Integer contentIdx;

    @ManyToOne
    @JoinColumn(name = "content_board_idx")
    BoardTable boardTable;

    @ManyToOne
    @JoinColumn(name = "content_writer_idx")
    UserTable userTable;
    String contentSubject;
    LocalDateTime cotentWriteDate;
    String contentText;
    String contentImage;

    public static ContentTable createContent(BoardTable board, UserTable user, String content_subject, String content_text) {
        ContentTable content = new ContentTable();
        content.setBoardTable(board);
        content.setUserTable(user);
        content.setContentSubject(content_subject);
        content.setContentText(content_text);
        content.setCotentWriteDate(LocalDateTime.now());

        return content;
    }
}
