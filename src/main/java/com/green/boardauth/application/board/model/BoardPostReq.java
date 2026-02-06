package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardPostReq {
    private String title;
    private String contents;
    private long userId;
}
