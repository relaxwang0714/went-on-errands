package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzh.mapper.UserMapper;
import com.wzh.model.User;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<User> search(User user) {
        // TODO Auto-generated method stub
        return userMapper.selectSelective(user);
    }

    @Override
    public User searchById(Long id) {
        // TODO Auto-generated method stub
        return  userMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<User> searchAll() {
        // TODO Auto-generated method stub
        return userMapper.selectAll();
    }



}
