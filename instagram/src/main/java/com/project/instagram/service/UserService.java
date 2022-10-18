package com.project.instagram.service;

import com.project.instagram.dto.RequestUserDto;
import com.project.instagram.dto.ResponseUserDto;
import com.project.instagram.model.UserInfo;

import java.util.List;

public interface UserService {
    String addUserInfo(RequestUserDto.signup requestUserDto);

    List<UserInfo> selectAllUserInfoList();

    UserInfo selectUserInfo(RequestUserDto.login requestUserDtoRead);
}