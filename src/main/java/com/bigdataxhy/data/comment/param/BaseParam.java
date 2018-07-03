package com.bigdataxhy.data.comment.param;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:13.
 */
public class BaseParam {

    private Integer userId;

    private String nikename;

    private String mobile;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
