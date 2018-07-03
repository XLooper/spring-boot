package com.bigdataxhy.data.manager.impl;

import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.dao.mapper.UserDOMapper;
import com.bigdataxhy.data.domain.datapojo.UserDO;
import com.bigdataxhy.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:08.
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public void insert(UserDO user) {
        userDOMapper.insert(user);
    }

    @Override
    public void insertSelective(UserDO user) {
        userDOMapper.insertSelective(user);
    }

    @Override
    public List<UserDO> listUser(BaseParam param) {
        return userDOMapper.listUser(param);
    }
}
