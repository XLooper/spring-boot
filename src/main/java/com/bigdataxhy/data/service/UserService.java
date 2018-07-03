package com.bigdataxhy.data.service;

import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.comment.user.UserInfo;

import java.util.List;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:09.
 */
public interface UserService {

    /**
     * 根据查询条件查询查询用户信息
     * @param param
     * @return
     */
    List<UserInfo> listUserInfos(BaseParam param);

    void sign(String mobile, String pswd);

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfoById(Integer id);
}
