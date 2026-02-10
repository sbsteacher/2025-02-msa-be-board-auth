package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGetRes {
    private long id;
    private String title;
    private String createdAt;
    private String nm;
}
