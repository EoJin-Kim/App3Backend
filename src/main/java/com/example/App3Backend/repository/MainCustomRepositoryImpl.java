package com.example.App3Backend.repository;

import com.example.App3Backend.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.App3Backend.entity.QBoardTable.boardTable;
import static com.example.App3Backend.entity.QUserTable.userTable;

@Repository
@RequiredArgsConstructor
@Transactional
public class MainCustomRepositoryImpl implements MainCustomRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public UserTable createUser(String user_id, String user_pw, String user_nick_name) {
        UserTable createUser = UserTable.createUser(user_id,user_pw,0,user_nick_name);
        em.persist(createUser);
        return createUser;
    }

    @Override
    public UserTable findUser(String user_id, String user_pw) {
        UserTable userTable = queryFactory.selectFrom(QUserTable.userTable)
                .where(QUserTable.userTable.userId.eq(user_id), QUserTable.userTable.userPw.eq(user_pw))
                .fetchOne();
        return userTable;
    }

    @Override
    public void updateUser(Integer userIdx, Integer user_autologin) {
        long execute = queryFactory.update(userTable)
                .set(userTable.userAutologin, user_autologin)
                .where(userTable.userIdx.eq(userIdx))
                .execute();
    }

    @Override
    public Integer checkAutoLogin(Integer userIdx) {
        Integer chk = queryFactory.select(userTable.userAutologin)
                .from(userTable)
                .where(userTable.userIdx.eq(userIdx))
                .fetchOne();
        return chk;
    }

    @Override
    public BoardTable createBoard(String boardName) {
        BoardTable board = BoardTable.createBoard(boardName);
        em.persist(board);
        return board;
    }

    @Override
    public List<BoardTable> getBoardList() {
        List<BoardTable> result = queryFactory.selectFrom(boardTable)
                .fetch();
        return result;
    }

    @Override
    public BoardTable findBoardByIdx(Integer boardIdx) {
        BoardTable findBoard = queryFactory.selectFrom(boardTable)
                .where(QBoardTable.boardTable.boardIdx.eq(boardIdx))
                .fetchOne();
        return findBoard;
    }

    @Override
    public UserTable findUserByIdx(Integer userIdx) {
        UserTable findUser = queryFactory.selectFrom(QUserTable.userTable)
                .where(QUserTable.userTable.userIdx.eq(userIdx))
                .fetchOne();

        return findUser;
    }

    @Override
    public ContentTable createContent(BoardTable findBoard, UserTable findUser, String content_subject, String content_text) {
        ContentTable createContent = ContentTable.createContent(findBoard, findUser, content_subject, content_text);
        em.persist(createContent);
        return null;
    }
}
