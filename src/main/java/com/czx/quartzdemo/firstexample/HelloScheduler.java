package com.czx.quartzdemo.firstexample;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-27 10:57
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob").usingJobData("message", "hello myJob")
                .usingJobData("mathValue", 3.141596F).build();
        //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger","group1")
                .usingJobData("message", "hello myTrigger")
                .usingJobData("doubleValue", 6.0D)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        //创建schedule实例
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

        System.out.println("main方法开始休眠");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main方法休眠结束");

    }
}
