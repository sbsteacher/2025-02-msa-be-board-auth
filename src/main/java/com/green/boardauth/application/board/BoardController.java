package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.BoardPostReq;
import com.green.boardauth.configuration.model.ResultResponse;
import com.green.boardauth.configuration.model.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
