package com.wzh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.google.gson.JsonObject;
import com.wzh.feign.PaotuiFeign;
import com.wzh.model.AddressCode;
import com.wzh.model.Business;
import com.wzh.model.Geocoder;
/**
 * 
 * @author wang
 *
 */
@Service
public class PaotuiServiceImpl implements PaotuiService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaotuiFeign paotuiFeign;
    @Override
    public int insert(Business business) {
        // TODO Auto-generated method stub
        return paotuiFeign.insert(business);
    }
 
    @Override
    public int ditance(String type, String start, String finish) {
        String key ="db0bd43565d182494ece437780cbb150";
        String url2="http://restapi.amap.com/v3/geocode/geo?batch=true&key="+key+"&address="+start+"|"+finish+"&city=杭州";
        AddressCode addressCode = restTemplate.getForObject(url2, AddressCode.class);
        String address =addressCode.getGeocodes().get(0).getLocation();
        String address1 =addressCode.getGeocodes().get(1).getLocation();
       // System.out.println(addressCode.getGeocodes().get(0).getLocation());

        //这里可以用|批量计算地址
        String url="http://restapi.amap.com/v3/distance?&origins="+address+""
                + "&destination="+address1+"&output=JSON&key="+key;
        
        Geocoder geocoder = restTemplate.getForObject(url, Geocoder.class);
        int distance = (geocoder.getResults().get(0).getDistance())/1000;
        System.out.print(distance);
        System.out.println(type);
        return paotuiFeign.searchMoney(type, distance);
        //return 0;
    }
    @Override
    public ArrayList<Business> searchBySatatus(Long userid, int status) {
        // TODO Auto-generated method stub
        
        return paotuiFeign.searchByStatus(userid, status);
    }

}
