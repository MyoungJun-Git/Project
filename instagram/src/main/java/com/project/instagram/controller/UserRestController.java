package com.project.instagram.controller;

import com.project.instagram.model.UserInfo;
import com.project.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/instagramAPI/main")
    public String test() {
        return "spring boot";
    }

    @GetMapping("/instagramAPI/jpaTest")
    public Model japTest(Model model) {
        System.out.println("UserRestController /instagramAPI/jpaTest ! ");

        /*
        //첫번째 방법 : 개별 사용자정보 호출
        UserInfo userInfo = userService.showUserInfo("newwonmj");
        System.out.println("getUserId : " + userInfo.getUserId());
        System.out.println("getUserPw : " + userInfo.getUserPw());
        System.out.println("getUserNm : " + userInfo.getUserNm());
        System.out.println("getUserNickname : " + userInfo.getUserNickname());
        */

        //두번째 방법 : 전체 사용자정보 호출
        List<UserInfo> userInfoList = userService.showUserInfoList();

        //model.addAttribute("userInfoList", userInfoList);
        return model;
    }
}