package com.czx.quartzdemo.fifthexample;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-28 22:55
 */
public class FifthJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(LocalDateTime.now());
        System.out.println("Hello Job");
    }
}
