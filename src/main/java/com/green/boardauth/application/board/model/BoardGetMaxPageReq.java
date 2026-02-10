package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@ToString
public class BoardGetMaxPageReq {
    private int size;
    private String searchText;

    public BoardGetMaxPageReq(int size, @BindParam("search_text") String searchText) {
        this.size = size;
        this.searchText = searchText;
    }
}
