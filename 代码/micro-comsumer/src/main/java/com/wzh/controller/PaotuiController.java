package com.wzh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.model.Business;
import com.wzh.service.PaotuiService;

@RestController
@RequestMapping("/paotui")
public class PaotuiController {
    @Autowired
    private PaotuiService paotuiService;
    @GetMapping("insert/{userid}&{brief}&{type}&{positioncreate}&{positionfinish}&{price}&{phone}&{name}")
    public int insert(@PathVariable(value="userid") Long userid,@PathVariable(value="brief") String brief,
            @PathVariable(value="positioncreate") String positioncreate,@PathVariable(value="positionfinish") String positionfinish,
            @PathVariable(value="price") Integer price ,@PathVariable(value="phone") String phone,@PathVariable(value="type") 
            String type,@PathVariable(value="name") String name ){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Business business = new Business();
        business.setName(name);
        business.setUserId(userid);
        business.setType(type);
        business.setBrief(brief);
        business.setPhone(phone);
        business.setPositionCreate(positioncreate);
        business.setPositionFinish(positionfinish);
        business.setPrice(price);
        business.setStartTime(df.format(new Date()));
       // System.out.println(business.getBrief());
                
        return paotuiService.insert(business);
        
    }
    @GetMapping("search/{userid}/{status}")
    public ArrayList<Business> search(@PathVariable(value="userid") Long userid,@PathVariable(value="status") int status)
    {
        return paotuiService.searchBySatatus(userid,status);
        
    }

    @GetMapping("moneyrule/{type}/{start}/{finish}")
    public int distance(@PathVariable(value="type") String type,@PathVariable(value="start") String start,@PathVariable(value="finish") String finish)
    {
        return paotuiService.ditance(type,start,finish);
        
    }
    

}
