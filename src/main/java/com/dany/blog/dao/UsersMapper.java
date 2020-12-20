package com.dany.blog.dao;

import com.dany.blog.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}