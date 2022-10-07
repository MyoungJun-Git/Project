package com.project.instagram.repository;

import com.project.instagram.model.UserInfo;
import com.project.instagram.repository.UserRepository;
import lombok.Data;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Data
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em;

    @Override
    public UserInfo save(UserInfo userInfo) {
        em.persist(userInfo);
        return userInfo;
    }

    @Override
    public UserInfo findUserInfo(String userId) {
        UserInfo findUserInfo = em.find(UserInfo.class, userId);
        return findUserInfo;
    }

    @Override
    public void deleteByUserId(String userId) {
        UserInfo userInfo = findUserInfo(userId);
        em.remove(userInfo);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        System.out.println("UserRepositoryImpl showByUserInfo !");
        return em.createQuery("select userinfo from UserInfo userinfo", UserInfo.class).getResultList();
    }
}
