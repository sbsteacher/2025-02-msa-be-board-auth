package com.green.boardauth.configuration.security;

import com.green.boardauth.configuration.constants.ConstJwt;
import com.green.boardauth.configuration.model.JwtUser;
import com.green.boardauth.configuration.util.MyCookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenManager { //인증 처리 총괄
    private final ConstJwt constJwt;
    private final MyCookieUtil myCookieUtil;
    private final JwtTokenProvider jwtTokenProvider;

    public void setAccessTokenInCookie(HttpServletResponse res, JwtUser jwtUser) {
        String accessToken = ??;
    }

    //AT를 쿠키에 담는다.
    public void setAccessTokenInCookie(HttpServletResponse res, String accessToken) {
        myCookieUtil.setCookie(res
                            , constJwt.getAccessTokenCookieName()
                            , accessToken
                            , constJwt.getAccessTokenCookieValiditySeconds()
                            , constJwt.getAccessTokenCookiePath()
        );
    }

    //RT를 쿠키에 담는다.
    public void setRefreshTokenInCookie(HttpServletResponse res, String refreshToken) {
        myCookieUtil.setCookie(res
                             , constJwt.getRefreshTokenCookieName()
                             , refreshToken
                             , constJwt.getRefreshTokenCookieValiditySeconds()
                             , constJwt.getRefreshTokenCookiePath()
        );
    }
}
