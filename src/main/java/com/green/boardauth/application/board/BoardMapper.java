package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.BoardGetMaxPageReq;
import com.green.boardauth.application.board.model.BoardGetReq;
import com.green.boardauth.application.board.model.BoardGetRes;
import com.green.boardauth.application.board.model.BoardPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(BoardPostReq req);
    List<BoardGetRes> findAll(BoardGetReq req);
    int findMaxPage(BoardGetMaxPageReq req);
}
