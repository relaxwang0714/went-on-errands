package com.wzh.quartz;

import java.text.DateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Value;

import com.wzh.util.mysqlbackup;

public class BackupJob implements Job {

    @Value("${spring.datasource.username}")
    private String root;
    @Value("${spring.datasource.password}")
    private String password;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // TODO Auto-generated method stub
        mysqlbackup backup = new mysqlbackup();
        String url ="localhost";
        String savepath ="F:/sqlbackup";
        Date now = new Date();  
        DateFormat df= DateFormat.getDateTimeInstance();  
         String fileName = df.format(now)+".sql";  
         fileName=fileName.replaceAll(":", "_");   //这句话一定要添加，因为：这个符号会造成错误

        try {
            backup.exportDatabaseTool(url, root, password, savepath, fileName, "coldchain");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
