package com.project.instagram.repository;

import com.project.instagram.model.UserInfo;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserInfo save(UserInfo userInfo); //회원정보 저장
    UserInfo findUserInfo(String userId); //회원정보 조회
    void deleteByUserId(String userId); //회원정보 삭제
    List<UserInfo> findAllUserInfo(); //회원정보 리스트 조회
}