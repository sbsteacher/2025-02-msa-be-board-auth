package com.green.boardauth.application.user;

import com.green.boardauth.application.user.model.UserSignInReq;
import com.green.boardauth.application.user.model.UserSignInRes;
import com.green.boardauth.application.user.model.UserSignUpReq;
import com.green.boardauth.configuration.model.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResultResponse<Integer> signUp(@RequestBody UserSignUpReq req) {
        log.info("req: {}", req);
        int result = userService.signUp(req);
        return new ResultResponse<>("회원가입 성공", result);
    }

    @PostMapping("/signin")
    public ResultResponse<?> signIn(@RequestBody UserSignInReq req) {
        log.info("req: {}", req);
        UserSignInRes userSignInRes = userService.signIn(req);
        //보안 쿠키 처리
        if(userSignInRes != null) {

        }
        return new ResultResponse<>(userSignInRes == null ? "로그인 실패" : "로그인 성공", userSignInRes);
    }
}
