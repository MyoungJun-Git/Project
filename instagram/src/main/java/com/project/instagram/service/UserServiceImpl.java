package com.project.instagram.service;

import com.project.instagram.model.UserInfo;
import com.project.instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String addUserInfo(UserInfo userInfo) {
        UserInfo addUserInfo = userRepository.save(userInfo);
        return addUserInfo.getUserId();
    }

    @Override
    public UserInfo showUserInfo(String userId) {
        UserInfo userInfo = userRepository.findUserInfo(userId);
        return userInfo;
    }

    @Override
    public void deleteUserInfo(String userId) {
        userRepository.deleteByUserId(userId);
    }
    @Override
    public List<UserInfo> showUserInfoList() {
        List<UserInfo> userInfoList = userRepository.findAllUserInfo();
        System.out.println(" UserServiceImpl showUserInfoList! " );
        for (int i = 0; i < userInfoList.size(); i++) {
            System.out.println("UserId : " + userInfoList.get(i).getUserId());
            System.out.println("UserPassword : " + userInfoList.get(i).getUserPw());
            System.out.println("UserName : " + userInfoList.get(i).getUserNm());
            System.out.println("UserNickname : " + userInfoList.get(i).getUserNickname());
        }

        return userInfoList;
    }
}
