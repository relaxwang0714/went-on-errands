package com.wzh.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wzh.entity.BusinessPojo;
import com.wzh.feign.CustomerFeignClient;
import com.wzh.model.Business;
import com.wzh.model.User;
import com.wzh.service.BusinessService;
import com.wzh.util.ExcelUtil;
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private CustomerFeignClient userFeignClient;
    @Autowired
    private BusinessService businessService;
  //  private String[][] content;
    
    
    @PostMapping("/searchpojo")
    //@Cacheable(value = "business")//该注解表示可缓存的，会检查是否有这个缓存，如果有的话就直接取值了
    public ArrayList<Business> searchPojo(@RequestBody BusinessPojo businessPojo){
        
        return businessService.searchPojo(businessPojo) ;
        
    }
    
    @GetMapping("/all")
    @Cacheable(value = "business")
    public ArrayList<Business> searchAll(){
        
        return businessService.searchAll(); 
        
    }
    @PostMapping("/searchbySelect")
   // @Cacheable(value = "business")
    public ArrayList<Business> searchBySelect(@RequestBody Business business){

        return businessService.searchBySelect(business); 
        
    }
    
    @PostMapping("/insert")
    @CacheEvict(value="business", allEntries=true)
    public int insert(@RequestBody Business business){
        System.out.println(business.getStartTime());
        
        return businessService.insert(business); 
        
    }
    @GetMapping("/findbyid/{id}")
    
    public Business searchbyid(@PathVariable Long id){
        
        return businessService.findById(id);
        
    }
    @GetMapping("/jiedan/{collectorid}/{id}")
    @CacheEvict(value="business", allEntries=true) //删除缓存
    public int jiedan(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="id") Long id){
        Business business = new Business();
        business.setCollectorId(collectorid);
        business.setId(id);
        business.setStatus(1);
        return businessService.jiedan(business);
        
    }
    @GetMapping("/search2/{userid}/{status}")
    @Cacheable(value = "business")
    public ArrayList<Business> searchByStatus2(@PathVariable(value="userid") Long userid,@PathVariable(value="status") int status){
        Business business = new Business();
        business.setUserId(userid);
        business.setStatus(status);
        return businessService.searchBystatus(business);
        
    }
    @GetMapping("/search3/{collectorid}")
    @Cacheable(value = "business")
    public ArrayList<Business> searchByStatus3(@PathVariable(value="collectorid") Long collectorId){
        Business business = new Business();
        business.setCollectorId(collectorId);
      //  business.setStatus(id);
        return businessService.searchBystatus(business);
        
    }
    @GetMapping("/search/{collectorid}/{id}")
    public ArrayList<Business> searchByStatus(@PathVariable(value="collectorid") Long collectorid,@PathVariable(value="id") int id){
        Business business = new Business();
        business.setCollectorId(collectorid);
        business.setStatus(id);
        return businessService.searchBystatus(business);
        
    }
    
    @GetMapping("/request")
    public ArrayList<Business> needall(){
        
        return businessService.needAll();
        
    }
    @PostMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response){
        String status =request.getParameter("status");
        String type =request.getParameter("type");
        String time1 =request.getParameter("time1");
        String time2 =request.getParameter("time2");
        System.out.println(time1);
        BusinessPojo businessPojo = new BusinessPojo();
        businessPojo.setTime1(time1);
        businessPojo.setTime2(time2);
        businessPojo.setType(type);
        businessPojo.setStatus(Integer.parseInt(status));
        //excel标题
        String[] title = {"跑腿订单ID","用户ID","配送员ID","跑腿费","跑腿类型","简介","起点","终点","下单时间"};
        //excel文件名
        String fileName = "跑腿订单表"+System.currentTimeMillis()+".xls";
        //sheet名
        String sheetName = "跑腿订单表";
        ArrayList<Business> businesslist = businessService.searchPojo(businessPojo);
      //  System.out.println(businesslist.size());
        String[][] content = new String[100][17];
        System.out.println(businesslist.size());
       // content[i] = new String[10];
        for(int i=0;i<businesslist.size();i++){
            Business business=businesslist.get(i);
            content[i][0] =String.valueOf(business.getId());
            System.out.println(business.getId());
            content[i][1] =String.valueOf(business.getUserId());
            content[i][2] =String.valueOf(business.getCollectorId());
            content[i][3] =String.valueOf(business.getPrice());
            content[i][4] =business.getType();
            content[i][5] =business.getBrief();
            content[i][6] =business.getPositionCreate();
            content[i][7] =business.getPositionFinish();
            content[i][8] =business.getGmtCreate();
            
        }


        //创建HSSFWorkbook 
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

           //响应到客户端
            try{
                this.setResponseHeader(response, fileName);
                OutputStream os =response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();
                    
                
            }catch(Exception e){
                e.printStackTrace();
            }

}
  //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
