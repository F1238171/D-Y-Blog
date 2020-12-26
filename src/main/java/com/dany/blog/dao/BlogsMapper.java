package com.dany.blog.dao;

import com.dany.blog.model.Blogs;

public interface BlogsMapper {
    int deleteByPrimaryKey(Long blogId);

    int insert(Blogs record);

    int insertSelective(Blogs record);

    Blogs selectByPrimaryKey(Long blogId);

    int updateByPrimaryKeySelective(Blogs record);

    int updateByPrimaryKey(Blogs record);
}