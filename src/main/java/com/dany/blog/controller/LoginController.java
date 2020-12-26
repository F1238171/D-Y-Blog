package com.dany.blog.controller;


import com.dany.blog.model.Users;
import com.dany.blog.model.login.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@Api(value = "登录模块的接口")
public class LoginController {

    @ApiOperation(value="登录",httpMethod = "POST")
    //说明一组参数
    @ApiImplicitParams({

            @ApiImplicitParam(value = "用户名",name="username",type = "query",dataType = "String",example = "dlzz",required = true),
            @ApiImplicitParam(value = "密码",name = "password",type = "query",dataType = "String",example = "dlzz",
                    required = true)
    })
    @PostMapping("/user")
    @ApiResponses({
            @ApiResponse(code=702,message = "参数错误"),
            @ApiResponse(code=703,message = "权限不足")
    })
    public User login(@RequestParam String username,@RequestParam String password)
    {
        return new User(username,password);
    }
}
