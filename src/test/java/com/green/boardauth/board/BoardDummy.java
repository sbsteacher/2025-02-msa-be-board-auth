package com.green.boardauth.board;

import com.green.boardauth.Dummy;
import com.green.boardauth.application.board.BoardMapper;
import com.green.boardauth.application.board.model.BoardPostPutReq;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class BoardDummy extends Dummy {

    final int ADD_ROW_COUNT = 10_000;

    @Test
    void generate() {

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
        try {
            for (int i = 0; i < ADD_ROW_COUNT; i++) {
                String title = koFaker.book().title();
                String contents = koFaker.lorem().sentence(30);
                long userId = koFaker.random().nextInt(4, 1003);

                System.out.printf("title: %s\n", title);
                System.out.printf("contents: %s\n", contents);
                System.out.printf("userId: %d\n", userId);

                BoardPostPutReq req = new BoardPostPutReq();
                req.setTitle(title);
                req.setContents(contents);
                req.setUserId(userId);
                boardMapper.save(req);
            }
            sqlSession.flushStatements();
        } catch (Exception e) {

        }
    }
}
