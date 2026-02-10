package com.green.boardauth.application.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@ToString
public class BoardGetReq {
    private int page;
    private int size;
    private String searchText;
    private int startIdx;

    public BoardGetReq(int page, int size, @BindParam("search_text") String searchText) {
        this.page = page;
        this.size = size;
        this.searchText = searchText;
        this.startIdx = (page - 1) * size;
    }
}
