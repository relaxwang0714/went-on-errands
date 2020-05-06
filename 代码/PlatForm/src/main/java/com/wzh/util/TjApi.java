package com.wzh.util;

import net.minidev.json.JSONObject;

public class TjApi {
    public String getSiteId(){ 
        try {
            JSONObject header = new JSONObject();
            header.put("username", "");//用户名
            header.put("password", "!");//用户密码
            header.put("token", "");//申请到的token
            header.put("account_type", "1");

            String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getSiteList";
            String charset = "utf-8";

            JSONObject params = new JSONObject();
            params.put("header", header);

            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
            String s = new String(res);
            System.out.println(s);    
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;

    
      
}
    public String getPV(String id){
        String s ="";
        try {
            JSONObject header = new JSONObject();
            header.put("username", "18057936630");//用户名
            header.put("password", "143565");//用户密码
            header.put("token", "67576");//申请到的token
            header.put("account_type", "1");

//          String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getSiteList";
            String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getData";
            String charset = "utf-8";


            JSONObject body = new JSONObject();
            body.put("siteId","10646729");
            body.put("method","overview/getTimeTrendRpt");//需要获取的数据
            body.put("start_date","20180520");
            body.put("end_date","20180622");
            body.put("metrics","pv_count,visitor_count,ip_count");//指标,数据单位

            JSONObject params = new JSONObject();
            params.put("header", header);
            params.put("body", body);

            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
             s = new String(res);
            System.out.println(s);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return s;
        
    }
}
