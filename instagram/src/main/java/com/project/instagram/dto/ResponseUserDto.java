package com.project.instagram.dto;

import com.project.instagram.model.UserInfo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class ResponseUserDto {
    private final String userId;
    private final String userName;
    private final String userNickname;

    public ResponseUserDto(UserInfo i_userInfo) {
        this.userId = i_userInfo.getUserId();
        this.userName = i_userInfo.getUserName();
        this.userNickname = i_userInfo.getUserNickname();
    }
}