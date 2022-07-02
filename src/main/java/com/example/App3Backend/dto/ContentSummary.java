package com.example.App3Backend.dto;

import com.example.App3Backend.entity.ContentTable;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ContentSummary {
    String content_idx;
    String content_nick_name;
    String content_write_date;
    String content_subject;

    public static ContentSummary create(ContentTable contentTable){
        ContentSummary contentSummary = new ContentSummary();
        contentSummary.setContent_idx(contentTable.getContentIdx().toString());
        contentSummary.setContent_nick_name(contentTable.getUserTable().getUserNickNake());
        contentSummary.setContent_write_date(contentTable.getCotentWriteDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
        contentSummary.setContent_subject(contentTable.getContentSubject());

        return contentSummary;


    }
}
