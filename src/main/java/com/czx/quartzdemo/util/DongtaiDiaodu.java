package com.czx.quartzdemo.util;

import org.quartz.SchedulerException;

/**
 * @Author czx
 * @Description 动态调度任务
 * @Version 2019-03-01 15:39
 */
public class DongtaiDiaodu {
    public static void main(String[] args) throws SchedulerException {
        QuartzManager.addJob("testJob", "jobGroup1",
                "testTrigger", "triggerGroup1",
                TestJob.class, 2);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        QuartzManager.modifyJobTime("testTrigger", "triggerGroup1",
                5);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        QuartzManager.removeJob("testJob", "jobGroup1",
                "testTrigger", "triggerGroup1");

        QuartzManager.shutdownJobs();
    }
}
