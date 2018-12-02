package com.wzh.feign;

import java.util.ArrayList;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzh.model.Business;


    @FeignClient(name="micro-provider-business",fallback=FeignClientFallback.class)
    public interface BusinessFeign {
        @RequestMapping(value="business/request", method=RequestMethod.GET)
        public ArrayList<Business> waitAll();
        
        @RequestMapping(value="business/findbyid/{id}", method=RequestMethod.GET)
        public Business findById(@PathVariable(value="id") Long id);
        
        @RequestMapping(value="business/jiedan/{collectorid}/{id}", method=RequestMethod.GET)
        public int jiedan(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="id") Long id);
        
        @RequestMapping(value="business/search/{collectorid}/{id}", method=RequestMethod.GET)
        public ArrayList<Business> searchByStatus(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="id") Long id);
    }
    @Component
    class FeignClientFallback implements BusinessFeign{

        @Override
        public ArrayList<Business> waitAll() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Business findById(Long id) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int jiedan(Long collectorid, Long id) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public ArrayList<Business> searchByStatus(Long collectorid, Long id) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    

      
        
    

