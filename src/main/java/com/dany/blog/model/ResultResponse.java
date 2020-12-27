package com.dany.blog.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultResponse<T> implements Serializable {

    Integer code;
    T data;

    public ResultResponse(Integer code, T data) {
        this.code=code;
        this.data=data;
    }
}
