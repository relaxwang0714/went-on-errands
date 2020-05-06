package com.wzh.mapper;

import java.util.ArrayList;

import com.wzh.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    ArrayList<User> selectSelective(User record);

    ArrayList<User> selectAll();
}