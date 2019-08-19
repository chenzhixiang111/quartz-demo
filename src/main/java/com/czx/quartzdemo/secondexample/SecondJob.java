package com.czx.quartzdemo.secondexample;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * @Author czx
 * @Description Job第二种获取context中信息的方法
 * 在Job类中写入成员变量和相应的get，set方法，
 * 之后在给JobDataMap传入键值对的时候，键的名字和成员变量名字一样，框架就会利用反射自动给成员变量赋值
 * 但是为什么我测试出来不可以！！？？
 * @Version 2019-02-27 23:05
 */
public class SecondJob implements Job {

    private String message;
    private float triggerValue;
    private int jobValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getTriggerValue() {
        return triggerValue;
    }

    public void setTriggerValue(float triggerValue) {
        this.triggerValue = triggerValue;
    }

    public int getJobValue() {
        return jobValue;
    }

    public void setJobValue(int jobValue) {
        this.jobValue = jobValue;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println(message + ", "+ triggerValue);
    }

}
