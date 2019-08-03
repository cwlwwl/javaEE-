package com.fs.mapper;

import com.fs.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
}