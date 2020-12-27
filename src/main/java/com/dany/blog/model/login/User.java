package com.dany.blog.model.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    @ApiModelProperty(name = "username", value = "用户名", required = true, example = "dlzz2013", dataType = "string")
    public String username;
    @ApiModelProperty(name = "password", value = "密码", required = true, example = "dlzz2013", dataType = "string")
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
