package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.BoardGetMaxPageReq;
import com.green.boardauth.application.board.model.BoardGetReq;
import com.green.boardauth.application.board.model.BoardGetRes;
import com.green.boardauth.application.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int postBoard(BoardPostReq req) {
        return boardMapper.save(req);
    }

    public List<BoardGetRes> getBoardList(BoardGetReq req) {
        return boardMapper.findAll(req);
    }

    public int getBoardMaxPage(BoardGetMaxPageReq req) {
        return boardMapper.findMaxPage(req);
    }
}
