package com.example.App3Backend.repository;

import com.example.App3Backend.entity.UserTable;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional
public class MainCustomRepositoryImpl implements MainCustomRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;
    public UserTable createUser(String user_id, String user_pw, String user_nick_name) {
        UserTable createUser = UserTable.createUser(user_id,user_pw,0,user_nick_name);
        em.persist(createUser);
        return createUser;
    }
}
