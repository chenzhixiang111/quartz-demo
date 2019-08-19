package com.czx.quartzdemo.fifthexample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author czx
 * @Description 认识CronTrigger和cron表达式
 * @Version 2019-02-28 22:59
 */
public class FifthScheduler {
    public static void main(String[] args) throws ParseException, SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(FifthJob.class).withIdentity("fifthjob").build();

        //1.2019年的每天的23点10分触发一次
//        String cronTime = "0 10 23 ? * * 2019";
        //2.每天的晚上23点整到23点59分和10点整到10点59分，每隔5秒执行一次
//        String cronTime = "0/5 * 10,23 * * ? *";
        //3.每月周一至周五的23点23分触发一次
//        String cronTime = "0 23 23 ? * 1/5 *";
        //4.每月的最后一天的23点25分触发一次
//        String cronTime = "0 25 23 L * ?";
        //5.每月第一个周一的14点15分触发一次
        String cronTime = "1 25 14 ? * 1#1 ";
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTime))
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        //scheduler是一个单例对象
        Scheduler scheduler = factory.getScheduler();
        //schedulerJob方法会得到一个Date类型的返回值，它表示最近一次即将执行的时间
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        System.out.println(sdf.format(date));
        scheduler.start();
//        scheduler.standby();//将调度器暂时挂起，挂起的调度器可以重新开启
        /*
        将调度器停止，停止后的调度器无法重新start。这个方法里面可以传boolean类型的参数
        true表示执行完还在执行的任务再停止，false表示立刻停止
         */
//        scheduler.shutdown();
    }

}
