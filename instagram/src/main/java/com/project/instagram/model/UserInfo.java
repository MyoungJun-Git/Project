package com.project.instagram.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


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
    private String userId;       //사용자 아이디
    private String userPw;       //사용자 패스워드
    private String userNm;       //사용자 성명
    private String userNickname; //사용자 이름
}
