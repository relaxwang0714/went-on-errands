package com.wzh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.feign.CustomerFeignClient;
import com.wzh.model.Business;
import com.wzh.model.User;
import com.wzh.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerFeignClient customerFeign;
    @Autowired
    private CustomerService customerService;
    @Cacheable(value = "customer")
    @PostMapping("/search")
    public ArrayList<User> search(@RequestBody User user){
        System.out.println(user.getUserName());
        return customerService.search(user);
}
    @GetMapping("/searchbyid/{id}")
    public User searchById(@PathVariable Long id){
        return customerService.searchById(id);
}
    @GetMapping("/searchall")
    public ArrayList<User> searchAll(){
        return customerService.searchAll();
}
    @GetMapping("/searchbusiness/{userid}")
    public ArrayList<Business> searchBusinessById(@PathVariable Long userid){
        return customerFeign.findById(userid);
}
    @GetMapping("/searchevaluate/{userid}")
    public ArrayList<Business> searchevaluate(@PathVariable Long userid){
        return customerFeign.findById(userid);
}
//    @PostMapping("/update}")
//    public int update(@RequestBody User user){
//        return customerFeign.findById(userid);
//}
}