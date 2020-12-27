package com.dany.blog.controller;


import com.dany.blog.dao.UsersMapper;
import com.dany.blog.model.ResultResponse;
import com.dany.blog.model.Users;
import com.dany.blog.model.login.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping("login")
@Api(value = "登录模块的接口")
public class LoginController {

    @Autowired
    UsersMapper usersMapper;
    @ApiOperation(value="登录",httpMethod = "POST")
    //说明一组参数
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名",name="username",type = "query",dataType = "String",example = "dlzz",required = true),
            @ApiImplicitParam(value = "密码",name = "password",type = "query",dataType = "String",example = "dlzz",required = true)
    })
    @PostMapping("/user")
    @ApiResponses({
            @ApiResponse(code=200,message = "登录成功"),
    })
    public ResultResponse<User> login(@RequestBody User user)
    {
        Users users = usersMapper.selectByAccount(user.username);
        String result="用户名或密码错误";
        Integer code = 700;
        if (users!=null) {
            result = users.getPassword().equals(user.password) ? "登录成功" : "用户名或密码失败";
            code = 200;
        }
        return new ResultResponse<User>(code,user);
    }
}
