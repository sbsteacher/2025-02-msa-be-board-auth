package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.BoardGetReq;
import com.green.boardauth.application.board.model.BoardGetRes;
import com.green.boardauth.application.board.model.BoardPostReq;
import com.green.boardauth.configuration.model.ResultResponse;
import com.green.boardauth.configuration.model.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //import com.green.boardauth.configuration.model.UserPrincipal;
    @PostMapping
    public ResultResponse<?> postBoard(@AuthenticationPrincipal UserPrincipal userPrincipal
                                     , @RequestBody BoardPostReq req) {
        log.info("통신됐다!!");
        log.info("signedUserId: {}", userPrincipal.getSignedUserId());
        log.info("req: {}", req);
        req.setUserId( userPrincipal.getSignedUserId() );
        int result = boardService.postBoard(req);
        String message = result == 1 ? "등록 성공" : "등록 실패";
        return new ResultResponse<>(message, result);
    }

    @GetMapping
    public ResultResponse<?> getBoardList(@ModelAttribute BoardGetReq req) {
        log.info("req: {}", req);
        List<BoardGetRes> list = boardService.getBoardList(req);
        return new ResultResponse<>( String.format("%d rows", list.size()), list );
    }
}
