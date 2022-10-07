package com.project.instagram.service;

import com.project.instagram.model.UserInfo;

import java.util.List;

public interface UserService {
    String addUserInfo(UserInfo userInfo);
    UserInfo showUserInfo(String userId);
    void deleteUserInfo(String userId);
    List<UserInfo> showUserInfoList();
}
