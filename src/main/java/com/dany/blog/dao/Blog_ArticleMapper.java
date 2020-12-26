package com.dany.blog.dao;

import com.dany.blog.model.Blog_Article;

public interface Blog_ArticleMapper {
    int deleteByPrimaryKey(Long blogId);

    int insert(Blog_Article record);

    int insertSelective(Blog_Article record);

    Blog_Article selectByPrimaryKey(Long blogId);

    int updateByPrimaryKeySelective(Blog_Article record);

    int updateByPrimaryKey(Blog_Article record);
}