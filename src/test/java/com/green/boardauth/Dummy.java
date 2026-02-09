package com.green.boardauth;

import net.datafaker.Faker;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.Locale;

//Slice Test (레이어 테스트)- Mybatis 테스트 용도, 오로지 mapper쪽만 빈등록 해서 테스트
@MybatisTest
//Persistence Test는 기본적으로 H2 경량 데이터베이스를 이용한다. 경량 DB로 변경하지 않겠다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Test는 트랜잭션으로 작동하며 테스트가 끝나면 Rollback 시킨다.
// 그런데 우리는 실제로 데이터를 insert해야하기 때문에 Rollback을 끈다.
@Rollback(false)
public class Dummy {
    @Autowired //DI
    protected SqlSessionFactory sqlSessionFactory;

    protected Faker koFaker = new Faker(new Locale("ko")); //한글
    protected Faker enFaker = new Faker(new Locale("en")); //영어
}
