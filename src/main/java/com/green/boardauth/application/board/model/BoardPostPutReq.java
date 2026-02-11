package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardPostPutReq {
    private long id; // insert한 row의 pk값을 담을 공간 할당
    private String title;
    private String contents;
    private long userId;
}
