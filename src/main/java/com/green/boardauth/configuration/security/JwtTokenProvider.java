package com.green.boardauth.configuration.security;

import com.green.boardauth.configuration.constants.ConstJwt;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;
import javax.crypto.SecretKey;

@Slf4j
@Component //역할이 없는 빈등록
public class JwtTokenProvider {
    private final ObjectMapper objectMapper; //(내장)Jackson 라이브러리 DI받을 속성
    private final ConstJwt constJwt;
    private final SecretKey secretKey;

    public JwtTokenProvider(ObjectMapper objectMapper, ConstJwt constJwt) {
        this.objectMapper = objectMapper;
        this.constJwt = constJwt;
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(constJwt.getSecretKey()));

        log.info("constJwt: {}", this.constJwt);
    }


}
