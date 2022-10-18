package com.project.instagram.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


//@Getter @Setter          //Getter Setter
//@RequiredArgsConstructor //생성자 자동주입
//Model패키지안에 Entity Class에는 Setter를 갖지 않도록한다. @DATA >> Getter, Setter, RequiredArgsConstructor 모두포함하고있음.
//@Data   //Getter Setter RequiredArgsConstructor 합친것을 의미

@Entity //객체 매핑. 이게 붙은 클래스는 JPA가 관리하는 것으로 엔티티라고 불림
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 생성해준다.
public class UserInfo {
    //@GeneratedValue(strategy = GenerationType.IDENTITY) 자동증분 [시퀀스]

    @Id //PK(Primary Key)
    private String userId;               //사용자 아이디
    private String userName;             //사용자 성명
    private String userNickname;         //사용자 닉네임
    private String userPassword;         //사용자 패스워드
    private String userConfirmPassword;  //사용자 패스워드 확인

    @Builder
    public UserInfo(String i_userId, String i_userName, String i_userNickname, String i_userPassword, String i_userConfirmPassword) {
        this.userId = i_userId;
        this.userName = i_userName;
        this.userNickname = i_userNickname;
        this.userPassword = i_userPassword;
        this.userConfirmPassword = i_userConfirmPassword;
    }
}
