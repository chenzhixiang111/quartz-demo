package com.czx.quartzdemo.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * @Author czx
 * @Description
 * @Version 2019-03-01 15:36
 */
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("当前时间" + LocalDateTime.now());
    }
}
