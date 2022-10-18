package com.project.instagram.dto;

import com.project.instagram.model.UserInfo;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
public class RequestUserDto {
    /**
     * ! InnerClass를 통하여 requestDTO역할 분리
     */
    
    @Getter
    @NoArgsConstructor
    public static class signup {
        @Email(message = "올바른 형식의 이메일 주소여야 합니다.")
        @NotBlank(message = "아이디를 입력해주세요.")
        private String userId;
        @NotBlank(message = "이름을 입력해주세요.")
        private String userName;
        @NotBlank(message = "닉네임을 입력해주세요.")
        private String userNickname;
        @NotBlank(message = "패스워드를 입력해주세요.")
        private String userPassword;
        @NotBlank(message = "패스워드확인을 입력해주세요.")
        private String userConfirmPassword;

        /**
         *
         * @param i_userId
         * @param i_userName
         * @param i_userNickname
         * @param i_userPassword
         * @param i_userConfirmPassword
         */
        @Builder
        public signup(String i_userId, String i_userName, String i_userNickname, String i_userPassword, String i_userConfirmPassword) {
            this.userId = i_userId;
            this.userName = i_userName;
            this.userNickname = i_userNickname;
            this.userPassword = i_userPassword;
            this.userConfirmPassword = i_userConfirmPassword;
        }

        /**
         *
         * @return
         */
        public UserInfo toEntity() {
            return UserInfo.builder()
                    .i_userId(userId)
                    .i_userName(userName)
                    .i_userNickname(userNickname)
                    .i_userPassword(userPassword)
                    .i_userConfirmPassword(userConfirmPassword)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class login {
        @Email(message = "올바른 형식의 이메일 주소여야 합니다.")
        @NotBlank(message = "아이디를 입력해주세요.")
        private String userId;

        @NotBlank(message = "패스워드를 입력해주세요.")
        private String userPassword;

        /**
         *
         * @param i_userId
         */
        @Builder
        public login(String i_userId, String i_userPassword) {
            this.userId = i_userId;
            this.userPassword = i_userPassword;
        }

        /**
         *
         * @return
         */
        public UserInfo toEntity() {
            return UserInfo.builder()
                    .i_userId(userId)
                    .i_userPassword(userPassword)
                    .build();
        }
    }
}