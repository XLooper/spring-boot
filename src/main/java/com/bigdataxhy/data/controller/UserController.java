package com.bigdataxhy.data.controller;

import com.bigdataxhy.data.comment.param.BaseParam;
import com.bigdataxhy.data.comment.user.UserInfo;
import com.bigdataxhy.data.service.UserService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/6/28 15:07.
 */
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
@ResponseBody
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/list")
    public List<UserInfo> userInfos(BaseParam param) {

        return userService.listUserInfos(param);
    }


    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public String sign(String mobile, String pswd) {
        userService.sign(mobile, pswd);
        return "ok";
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public UserInfo findUserById(@PathVariable (value = "id") Integer id) {
        return userService.getUserInfoById(id);
    }

}
