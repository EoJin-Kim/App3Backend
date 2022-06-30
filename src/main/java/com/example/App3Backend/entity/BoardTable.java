package com.example.App3Backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BoardTable {

    @Id
    @GeneratedValue
    Integer boardIdx;

    String boardName;
}
