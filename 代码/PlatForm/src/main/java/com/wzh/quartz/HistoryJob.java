package com.wzh.quartz;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wzh.model.History;


public class HistoryJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // TODO Auto-generated method stub
    //    ArrayList<History> user =copymapper.getuserSQL();
     //   System.out.println(user.toString());
     //   copymapper.insertSQL(user);
        System.out.println("数据库备份任务, 当前时间:"+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

}
