package com.bigdataxhy.data.service.impl;

import com.bigdataxhy.core.utils.SecurityUtil;
import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.comment.user.UserInfo;
import com.bigdataxhy.data.domain.datapojo.UserDO;
import com.bigdataxhy.data.manager.UserManager;
import com.bigdataxhy.data.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:09.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserManager userManager;

    @Override
    public List<UserInfo> listUserInfos(BaseParam param) {

        List<UserDO> userDOS = userManager.listUser(param);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }

        List<UserInfo> userInfos = new ArrayList<>(userDOS.size());
        userDOS.forEach(user -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setMobile(user.getMobile());
            userInfo.setUsername(user.getUserName());
            userInfos.add(userInfo);
        });

        return userInfos;
    }

    @Override
    public void sign(String mobile, String pswd) {

        if (StringUtils.isEmpty(mobile) || mobile.length() != 11) {
            throw new RuntimeException("请输入正确的手机号");
        }

        if (StringUtils.isEmpty(pswd) || pswd.length() < 6) {
            throw new RuntimeException("非法的密码");
        }

        UserDO user;
        for (int i = 0; i < 10; i ++) {
            user = new UserDO();
            user.setUserName("不妖_" + i);
            user.setPswd(SecurityUtil.SHA1(pswd));
            user.setMobile(mobile.substring(0,9) + i);
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            userManager.insertSelective(user);
        }
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        if (id == null || id == 0) {
            throw new RuntimeException("请输入正确的用户ID");
        }

        UserDO user = userManager.getUserById(id);
        UserInfo userInfo = null;
        if (user != null) {
            userInfo = new UserInfo();

            userInfo.setUsername(user.getUserName());
            userInfo.setNickname(user.getNickname());
            userInfo.setMobile(user.getMobile().substring(0,3) + "******" + user.getMobile().substring(8));
        }
        return userInfo;
    }


    public static void main(String[] args) {

        System.out.println();

    }
}
