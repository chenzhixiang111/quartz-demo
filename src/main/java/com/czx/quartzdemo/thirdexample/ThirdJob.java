package com.czx.quartzdemo.thirdexample;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-28 21:53
 */
public class ThirdJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("当前时间：" + LocalDateTime.now());

        Trigger trigger = context.getTrigger();
        System.out.println("触发器开始时间是" + trigger.getStartTime());
        System.out.println("触发器结束时间是："+ trigger.getEndTime());
        JobKey jobKey = trigger.getJobKey();
        System.out.println("JobName : "+ jobKey.getName()+ ", "+ "jobGroup: "+ jobKey.getGroup());
    }
}
