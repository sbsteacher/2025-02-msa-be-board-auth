package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int postBoard(BoardPostReq req) {
        return boardMapper.save(req);
    }
}
