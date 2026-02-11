package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(BoardPostReq req);
    List<BoardGetRes> findAll(BoardGetReq req);
    int findMaxPage(BoardGetMaxPageReq req);
    BoardGetOneRes findById(long id);
    int deleteById(BoardDelReq req);
}
