package com.bigdataxhy.data.dao.mapper;

import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.domain.datapojo.UserDO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDOMapper extends Mapper<UserDO> {


    List<UserDO> listUser(BaseParam param);
}