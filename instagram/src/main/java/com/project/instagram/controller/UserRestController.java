package com.project.instagram.controller;

import com.project.instagram.dto.RequestUserDto;
import com.project.instagram.dto.ResponseUserDto;
import com.project.instagram.model.UserInfo;
import com.project.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/instagramAPI")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @GetMapping(value = "/main")
    public String test() {
        return "spring boot";
    }

    @PostMapping(value = "/getUserInfoList")
    public List<UserInfo> getUserInfo () {
        //log 순서 : trace >> debug >> info >> warn >> error

        log.info("/getUserInfo"); // default
        return userService.selectAllUserInfoList();
    }

    @PostMapping(value = "/getUserInfo")
    public UserInfo getUserInfo (@RequestBody @Valid RequestUserDto.login requestUserDtoLogin) {
        log.info("@ param : {}", requestUserDtoLogin); // default
        return userService.selectUserInfo(requestUserDtoLogin);
    }

    @PostMapping(value = "/setUserInfo")
    public String setUserInfo (@RequestBody @Valid RequestUserDto.signup requestUserDtoSignup) {
        log.info("@ param : {}", requestUserDtoSignup); // default
        return userService.addUserInfo(requestUserDtoSignup);
    }

}