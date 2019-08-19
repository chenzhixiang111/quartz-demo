package com.czx.quartzdemo.thirdexample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-28 21:56
 */
public class ThirdScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ThirdJob.class).withIdentity("thirdJob").build();

        Date startTime = new Date();
        startTime.setTime(startTime.getTime() + 3000);
        Date endTime = new Date();
        endTime.setTime(endTime.getTime() + 6000);
        /*
        Trigger是触发器,包含了任务触发的条件
         */
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(startTime).endAt(endTime)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().
                                withIntervalInSeconds(2).repeatForever())
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
