package com.bigdataxhy.data.manager;

import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.domain.datapojo.UserDO;

import java.util.List;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:08.
 */
public interface UserManager {

    void insert(UserDO user);

    void insertSelective(UserDO user);

    List<UserDO> listUser(BaseParam param);

    UserDO getUserById(Integer id);
}
