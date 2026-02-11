package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDelReq {
    private long id; //글 번호
    private long signedUserId; //로그인한 사용자 id
}
