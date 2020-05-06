package com.wzh.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wzh.mapper.PicMapper;
import com.wzh.model.Pic;


@RestController
public class UploadController {
    @Autowired
    private PicMapper picMapper; 
    @PostMapping(value="upload/guanggao")
public String upload_waste(@RequestParam("file1") MultipartFile file ,HttpServletRequest request) throws FileNotFoundException{
        
        
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File("src/main/resources/static/img/"+file.getOriginalFilename())));
        try {
            String number =request.getParameter("number");
            int id =Integer.parseInt(number);
            String brief =request.getParameter("Brief");
            String picturePath =file.getOriginalFilename();
            Pic pic = new Pic();
            pic.setId(id);
            pic.setBrief(brief);
            pic.setPicturepath(picturePath);
            picMapper.updateByPrimaryKey(pic);
            
            
           // good.setPicturePath(PicturePath);
         //   int result =goodsservice.insert(good);
            
            
            out.write(file.getBytes());
            out.flush();
            out.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return "提交成功！";
    
}
}
