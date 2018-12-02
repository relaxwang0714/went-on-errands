package com.wzh.feign;

import java.util.ArrayList;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzh.model.Business;



@FeignClient(name="micro-provider-business" )
public interface PaotuiFeign {
    @RequestMapping(value="business/insert", method=RequestMethod.POST)
    public int insert(@RequestBody Business business);
    
    @RequestMapping(value="business/search2/{userid}/{status}", method=RequestMethod.GET)
    public ArrayList<Business> searchByStatus(@PathVariable(value="userid") Long userid,@PathVariable(value="status") int status);
    
    @RequestMapping(value="moneyrole/searchbytype/{type}/{distance}", method=RequestMethod.GET)
    public int searchMoney(@PathVariable(value="type") String type,@PathVariable(value="distance") int distance);
    
    

}
@Component
class FeignClientFallback implements PaotuiFeign{

    @Override
    public int insert(Business business) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public int searchMoney(String type, int distance) {
        // TODO Auto-generated method stub
        return 1;
    }



    @Override
    public ArrayList<Business> searchByStatus(Long userid, int status) {
        // TODO Auto-generated method stub
        return null;
    }

 

    
}
