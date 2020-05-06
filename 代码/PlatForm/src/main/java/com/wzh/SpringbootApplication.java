package com.wzh;

import org.mybatis.spring.annotation.MapperScan;
import org.quartz.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.wzh.quartz.CronTriggerService;

//微服务注册
@EnableDiscoveryClient
//微服务feign组件支持
@EnableFeignClients
//微服务Hystrix组件支持
@EnableHystrix
@SpringBootApplication
@MapperScan("com.wzh.mapper")
/**
 * 
 * @author wang
 * @date 2018-5-31
 * spring boot的启动类
 *
 */
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    //    CronTriggerService example = new CronTriggerService();
      //  Scheduler scheduler = example.createScheduler();
       // example.scheduleJob(scheduler);
      //  scheduler.start();
    }
}
