package com.example.App3Backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

}
