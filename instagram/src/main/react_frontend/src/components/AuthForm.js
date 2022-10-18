import logo200Image from 'assets/img/logo/logo_200.png';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import * as CommonUtil from "../utils/CommonUtil.js";

class AuthForm extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            userId : "",
            userName : "",
            userNickname : "",
            userPassword : "",
            userConfirmPassword : ""
        }
    }
    
    get isLogin() {
        return this.props.authState === STATE_LOGIN;
    }

    get isSignup() {
        return this.props.authState === STATE_SIGNUP;
    }

    changeAuthState = authState => event => {
        event.preventDefault();

        this.props.onChangeAuthState(authState);
    };

    handleChange = e => {
        this.setState({[e.target.id] : e.target.value});
    }

    // componentDidMount() vs document.ready
  
    jpaTestCallbackFunction = i_result => {
        console.log(i_result.data);
        this.setState({id : i_result.data});
    }

    setUserInfoCallbackFunc = i_result => {
        console.log(i_result.data);

    }

    getUserInfoCallbackFunc = i_result => {
        console.log(i_result.data);
        
    }

    setUserInfo = event => {
        /**
         * ! event.preventDefault(); 사용이유
         *   - a태그 처럼 클릭이벤트 외에 별도의 브라우저 행동을 막기 위해 사용된다.
         */
        //CommonUtil.getAsncAxios('GET', '/instagramAPI/jpaTest', '{}', this.jpaTestCallbackFunction);

        
        /* console.log("userId : " + this.state.userId);
        console.log("userName : " + this.state.userName);
        console.log("userNickname : " + this.state.userNickname);
        console.log("userPassword : " + this.state.userPassword);
        console.log("userConfirmPassword : " + this.state.userConfirmPassword); */
        
        event.preventDefault();
        
        if ("LOGIN" === this.props.authState) {
            const urlInfo = "/instagramAPI/getUserInfo"
                , userInfo = {
                    userId : this.state.userId
                    , userPassword : this.state.userPassword
                };

            CommonUtil.getAsncAxios('POST', urlInfo, userInfo, this.getUserInfoCallbackFunc);
        } else if ("SIGNUP" === this.props.authState) {
            const urlInfo = "/instagramAPI/setUserInfo"
                , userInfo = {
                    userId : this.state.userId
                    , userName : this.state.userName
                    , userNickname : this.state.userNickname
                    , userPassword : this.state.userPassword
                    , userConfirmPassword : this.state.userConfirmPassword
                }

            CommonUtil.getAsncAxios('POST', urlInfo, userInfo, this.setUserInfoCallbackFunc);
        } else {;}
    };

    renderButtonText() {
        const { buttonText } = this.props;

        if (!buttonText && this.isLogin) {
            return 'Login';
        }

        if (!buttonText && this.isSignup) {
            return 'Signup';
        }

        return buttonText;
    }

    render() {
        const {
            showLogo,
            userIdLabel,
            userIdInputProps,
            userNameLabel,
            userNameProps,
            userNicknameLabel,
            userNicknameProps,
            userPasswordLabel,
            userPasswordInputProps,
            userConfirmPasswordLabel,
            userConfirmPasswordInputProps,
            children,
            onLogoClick,
        } = this.props;

        return (
        <Form onSubmit={this.setUserInfo}>
            {showLogo && (
            <div className="text-center pb-4">
                <img
                src={logo200Image}
                className="rounded"
                style={{ width: 60, height: 60, cursor: 'pointer' }}
                alt="logo"
                onClick={onLogoClick}
                />
            </div>
            )}

            <FormGroup>
                <Label for={userIdLabel}>{userIdLabel}</Label>
                <Input
                    id="userId"
                    onChange={this.handleChange}
                    value={this.state.userId}
                    {...userIdInputProps}
                    />
            </FormGroup>

            {this.isSignup && (
                <FormGroup>
                    <Label for={userNameLabel}>{userNameLabel}</Label>
                    <Input 
                        id="userName"
                        onChange={this.handleChange}
                        {...userNameProps} />
                </FormGroup>
            )}
            
            {this.isSignup && (
                <FormGroup>
                    <Label for={userNicknameLabel}>{userNicknameLabel}</Label>
                    <Input
                        id="userNickname"
                        onChange={this.handleChange}
                        {...userNicknameProps}
                    />
                </FormGroup>
            )}
            
            <FormGroup>
                <Label for={userPasswordLabel}>{userPasswordLabel}</Label>
                <Input
                    id="userPassword"
                    onChange={this.handleChange}
                    {...userPasswordInputProps}
                    />
            </FormGroup>

            {this.isSignup && (
                <FormGroup>
                    <Label for={userConfirmPasswordLabel}>{userConfirmPasswordLabel}</Label>
                    <Input
                        id="userConfirmPassword"
                        onChange={this.handleChange}
                        {...userConfirmPasswordInputProps}
                    />
                </FormGroup>
            )}

            {/* <FormGroup check>
                <Label check>
                    <Input type="checkbox" />{' '}
                    {this.isSignup ? 'Agree the terms and policy' : 'Remember me'}
                </Label>
            </FormGroup> */}

            <hr />
            <Button
                size="lg"
                className="bg-gradient-theme-left border-0"
                block
                onClick={this.setUserInfo}>
                {this.renderButtonText()}
            </Button>

            <div className="text-center pt-1">
            <h6>or</h6>
            <h6>
                {this.isSignup ? (
                <a href="#login" onClick={this.changeAuthState(STATE_LOGIN)}>
                    Login
                </a>
                ) : (
                <a href="#signup" onClick={this.changeAuthState(STATE_SIGNUP)}>
                    Signup
                </a>
                )}
            </h6>
            </div>

            {children}
        </Form>
        );
    }
}

export const STATE_LOGIN = 'LOGIN';
export const STATE_SIGNUP = 'SIGNUP';

AuthForm.propTypes = {
    //로그인 , 회원가입 상태
    authState: PropTypes.oneOf([STATE_LOGIN, STATE_SIGNUP]).isRequired,
    //로고 SHOW
    showLogo: PropTypes.bool,
    //아이디
    userIdLabel: PropTypes.string,
    userIdInputProps: PropTypes.object,
    //성명
    userNameLabel: PropTypes.string,
    userNameProps: PropTypes.object,
    //닉네임
    userNicknameLabel: PropTypes.string,
    userNicknameProps: PropTypes.object,
    //패스워드
    userPasswordLabel: PropTypes.string,
    userPasswordInputProps: PropTypes.object,
    //패스워드확인
    userConfirmPasswordLabel: PropTypes.string,
    userConfirmPasswordInputProps: PropTypes.object,
    //로고확인
    onLogoClick: PropTypes.func,
};

AuthForm.defaultProps = {
    authState: 'LOGIN',
    showLogo: true,
    userIdLabel: 'Email',
    userIdInputProps: {
        type: 'email',
        placeholder: '이메일 주소',
        autocomplete:"off"
    },
    userNameLabel: 'Name',
    userNameProps: {
        type: 'text',
        placeholder: '성명',
        autocomplete:"off"
    },
    userNicknameLabel: 'Nickname',
    userNicknameProps: {
        type: 'text',
        placeholder: '사용자 닉네임',
        autocomplete:"off"
    },
    userPasswordLabel: 'Password',
    userPasswordInputProps: {
        type: 'password',
        placeholder: '비밀번호',
        autocomplete:"off"
    },
    userConfirmPasswordLabel: 'Confirm Password',
    userConfirmPasswordInputProps: {
        type: 'password',
        placeholder: '비밀번호 확인',
        autocomplete:"off"
    },
    onLogoClick: () => {},
};

export default AuthForm;
