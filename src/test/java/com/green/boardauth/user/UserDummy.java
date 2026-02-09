package com.green.boardauth.user;

import com.green.boardauth.Dummy;
import com.green.boardauth.application.user.UserMapper;
import com.green.boardauth.application.user.model.UserSignUpReq;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class UserDummy extends Dummy {
    final int ADD_ROW_COUNT = 1_000;

    @Test
    void generate() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        for(int i=1; i<=ADD_ROW_COUNT; i++) {
            String uid = String.format("mic%04d", i);
            System.out.printf("uid: %s\n", uid);

            String nm = koFaker.name().lastName() + koFaker.name().firstName();
            System.out.printf("nm: %s\n", nm);

            String pw = "$2a$10$PdihkApucpvnoU3681i7Sux5epL1YWPYcokkSQDbKHePPt/pjjDSe"; //1212

            int gender = koFaker.random().nextInt(1, 2);
            System.out.printf("gender: %d\n", gender);

            UserSignUpReq req = new UserSignUpReq();
            req.setUid(uid);
            req.setNm(nm);
            req.setUpw(pw);
            req.setGender(gender);
            userMapper.signUp(req);
        }
        sqlSession.flushStatements();
    }
}
