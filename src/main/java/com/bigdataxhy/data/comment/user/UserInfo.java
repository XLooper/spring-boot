package com.bigdataxhy.data.comment.user;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:11.
 */
public class UserInfo {

    private String username;
    private String mobile;
    private String address;
    private String nickname;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserInfo() {
    }

    public UserInfo(String username, String mobile) {
        this.username = username;
        this.mobile = mobile;
    }
}
