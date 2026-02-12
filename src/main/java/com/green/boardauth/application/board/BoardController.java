package com.green.boardauth.application.board;

import com.green.boardauth.application.board.model.*;
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
                                     , @RequestBody BoardPostPutReq req) {
        log.info("통신됐다!!");
        log.info("signedUserId: {}", userPrincipal.getSignedUserId());
        log.info("req: {}", req);
        req.setUserId( userPrincipal.getSignedUserId() );
        long id = boardService.postBoard(req);
        String message = id > 0 ? "등록 성공" : "등록 실패";
        return new ResultResponse<>(message, id);
    }

    @GetMapping
    public ResultResponse<?> getBoardList(@ModelAttribute BoardGetReq req) {
        log.info("req: {}", req);
        List<BoardGetRes> list = boardService.getBoardList(req);
        return new ResultResponse<>( String.format("%d rows", list.size()), list );
    }

    @GetMapping("max_page")
    public ResultResponse<?> getBoardMaxPage(@ModelAttribute BoardGetMaxPageReq req) {
        log.info("req: {}", req);
        int maxPage = boardService.getBoardMaxPage(req);
        return new ResultResponse<>( String.format("maxPage: %d", maxPage), maxPage );
    }

    @GetMapping("{id}")
    public ResultResponse<?> getBoard(@PathVariable long id) {
        log.info("id: {}", id);
        BoardGetOneRes res = boardService.getBoard(id);
        return new ResultResponse<>( "조회 성공", res );
    }

    @GetMapping("related_search")
    public ResultResponse<?> getRelatedTitles(@RequestParam("search_text") String searchText) {
        List<String> list = boardService.getRelatedTitles(searchText);
        return new ResultResponse<>(String.format("%s rows", list.size()), list);
    }

    @PutMapping
    public ResultResponse<?> putBoard(@AuthenticationPrincipal UserPrincipal userPrincipal
                                    , @RequestBody BoardPostPutReq req) {
        req.setUserId( userPrincipal.getSignedUserId() );
        log.info("req: {}", req);
        boardService.putBoard(req);
        return new ResultResponse<>("수정 성공", req.getId());
    }

    @DeleteMapping
    public ResultResponse<?> delBoard(@AuthenticationPrincipal UserPrincipal userPrincipal
                                    , @ModelAttribute BoardDelReq req) {
        req.setSignedUserId( userPrincipal.getSignedUserId() ); //로그인한 사용자의 id값 담기
        log.info("req: {}", req);
        int result = boardService.delBoard(req);
        return new ResultResponse<>( result == 1 ? "삭제 성공" : "삭제 권한이 없습니다.", result );
    }
}
