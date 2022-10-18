package com.project.instagram.repository;

import com.project.instagram.dto.RequestUserDto;
import com.project.instagram.dto.ResponseUserDto;
import com.project.instagram.model.UserInfo;
import net.sf.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo save(UserInfo userInfo); //회원정보 저장

    List<UserInfo> findAll(); //회원정보 전체조회

    UserInfo findByUserIdAndUserPassword(String i_userId, String i_userPassword);

}