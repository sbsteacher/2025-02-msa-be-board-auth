package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardPostReq {
    private String title;
    private String contents;
    private long userId;
}
