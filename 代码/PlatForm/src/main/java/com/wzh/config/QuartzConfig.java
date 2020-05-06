package com.wzh.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * 配置任务调度中心
 * [QRTZ_JOB_DETAILS], [QRTZ_TRIGGERS] and [QRTZ_CRON_TRIGGERS]
 */
@Configuration
public class QuartzConfig {
	@Autowired
    private qiYuJobFactory qiYuJobFactory;//job工厂


//	@Bean
//	public Scheduler scheduler() throws IOException, SchedulerException {
//		SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
//		Scheduler scheduler = schedulerFactory.getScheduler();
//		scheduler.start();
//		return scheduler;
//	}
	 @Bean
	    public SchedulerFactoryBean schedulerFactoryBean() throws IOException,SchedulerException {
			 //这种方法用于spring对SchedulerFactory的管理，可以在job中注入bean
	        SchedulerFactoryBean factory = new SchedulerFactoryBean();
	      //用于quartz集群,QuartzScheduler 启动时更新己存在的Job，
	        //这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了  
	        factory.setOverwriteExistingJobs(true);
	        //注入配置文件
	        factory.setQuartzProperties(quartzProperties());

	        // 延时启动
	       // factory.setStartupDelay(20);
	       
	        //设置数据源(使用系统的主数据源，覆盖propertis文件的dataSource配置)
	       // factory.setDataSource(dataSource);

	        // 自定义Job Factory，用于Spring注入
	        factory.setJobFactory(qiYuJobFactory);

	        return factory;
	    }
	
	 @Bean  
	    public Scheduler scheduler() throws IOException, SchedulerException {  
	      return   schedulerFactoryBean().getScheduler();
	    }  
	
	/**
	 * 设置quartz属性
	 * @throws IOException
	 */
	public Properties quartzProperties() throws IOException {
		Properties prop = new Properties();
		prop.put("quartz.scheduler.instanceName", "ServerScheduler");
		prop.put("org.quartz.scheduler.instanceId", "AUTO");
		prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
		prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
		prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
		prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
		prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
		prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
		prop.put("org.quartz.jobStore.tablePrefix", "qrtz_");
		prop.put("org.quartz.jobStore.isClustered", "true");
		prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        //配置数据源
		prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
		prop.put("org.quartz.dataSource.quartzDataSource.URL", "jdbc:mysql://localhost:3306/quartz?characterEncoding=utf8&&useSSL=false");
		prop.put("org.quartz.dataSource.quartzDataSource.user", "root");
		prop.put("org.quartz.dataSource.quartzDataSource.password", "123456");
		prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "10");
		return prop;
	}
	
}