package com.czx.quartzdemo.secondexample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-27 23:06
 */
public class SecondScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SecondJob.class).withIdentity("secondJob")
                .usingJobData("message", "lalala")
                .usingJobData("jobValue", 666)
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("secondTrigger", "group1")
                .usingJobData("message", "hello world")
                .usingJobData("triggerValue", 3.11F)
                .startNow()//触发条件
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
