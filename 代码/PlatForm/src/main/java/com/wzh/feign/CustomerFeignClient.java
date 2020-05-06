package com.wzh.feign;

import java.util.ArrayList;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzh.model.Business;
import com.wzh.model.Collector;
import com.wzh.model.User;
/**
 * 
 * @author wang
 * feign用于微服务架构中的各个微服务的通信
 *
 */
@FeignClient(name="micro-provider-business",fallback=FeignClientFallback.class)
public interface CustomerFeignClient {
    @RequestMapping(value="/business/search2/{userid}", method=RequestMethod.GET)
    public ArrayList<Business> findById(@PathVariable(value="userid") Long userid);
    
    @RequestMapping(value="/collector/searchbydesc", method=RequestMethod.GET)
    public ArrayList<Collector> searchByDesc();

}
@Component
class FeignClientFallback implements CustomerFeignClient{

    @Override
    public ArrayList<Business> findById(Long id) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setId(-1L);
        user.setUserName("默认用户");
        return null;
    }

    @Override
    public ArrayList<Collector> searchByDesc() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
