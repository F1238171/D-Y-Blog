package com.dany.blog.dao;

import com.dany.blog.model.Articles;

public interface ArticlesMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);
}