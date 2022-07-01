package com.example.App3Backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class BoardTable {

    @Id
    @GeneratedValue
    Integer boardIdx;

    String boardName;

    public static BoardTable createBoard(String boardName) {
        BoardTable boardTable = new BoardTable();
        boardTable.setBoardName(boardName);
        return boardTable;
    }
}
