package com.wzh.service;

import java.util.ArrayList;

import com.wzh.model.User;

public interface CustomerService {
    ArrayList<User> search(User user);


    User searchById(Long id);


    ArrayList<User> searchAll();

}
