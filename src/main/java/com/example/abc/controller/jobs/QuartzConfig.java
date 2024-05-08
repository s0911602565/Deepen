package com.example.abc.controller.jobs;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.quartz.*;
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail showTime(){
        System.out.println("showTime方法運行");
        //綁定QuartzJob任務
        return JobBuilder.newJob(QuartzJob.class)
                //給當前的JobDetail取名字
                .withIdentity("Demo1")
                .storeDurably()
                .build();
    }

    //觸發器
    @Bean
    public Trigger showTimeTrigger(){
        System.out.println("showTimeTrigger方法運行");
        //cron表達式
        CronScheduleBuilder cronScheduleBuilder =
        //每5秒執行一次
        CronScheduleBuilder.cronSchedule("0/5 * * * * ? ");
        return TriggerBuilder.newTrigger()
                .forJob(showTime())
                .withIdentity("redisUpdateTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
