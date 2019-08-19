package com.czx.quartzdemo.forthexample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author czx
 * @Description 熟悉SimpleTrigger
 * @Version 2019-02-28 22:35
 */
public class ForthScheduler {
    public static void main(String[] args) throws SchedulerException {
        System.out.println(LocalDateTime.now());
        JobDetail jobDetail = JobBuilder.newJob(ForthJob.class).build();
        Date startTime = new Date();
        startTime.setTime(startTime.getTime() + 4000L);
        //距离当前时间4秒钟后首次执行，每隔2秒执行一次，执行3次后终止
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group2")
                .startAt(startTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3))
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
