package com.project.instagram.service;

import com.project.instagram.dto.RequestUserDto;
import com.project.instagram.dto.ResponseUserDto;
import com.project.instagram.model.UserInfo;
import com.project.instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    //회원정보저장
    public String addUserInfo(RequestUserDto.signup requestUserDto) {
        UserInfo addUserInfo = userRepository.save(requestUserDto.toEntity());
        return addUserInfo.getUserId();
    }

    @Override
    @Transactional
    public List<UserInfo> selectAllUserInfoList() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserInfo selectUserInfo(RequestUserDto.login requestUserDtoRead) {
        //UserInfo userInfo = requestUserDtoRead.toEntity().getUserId();
        return userRepository.findByUserIdAndUserPassword(requestUserDtoRead.toEntity().getUserId(), requestUserDtoRead.toEntity().getUserPassword());
    }
}
