package com.czx.quartzdemo.firstexample;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * @Author czx
 * @Description
 * @Version 2019-02-27 10:50
 */
public class HelloJob implements Job {
    /*
    JobExecutionContext对象是schedule对象在调用Job对象的时候传过来的参数
    因为每次执行任务都会创建一个新的Job对象，执行完以后Job对象在被GC销毁
    所以有必要让Job知道它当前所处的环境，就靠这个JobExecutionContext

     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印当前执行时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println(context.getJobDetail());
        System.out.println("JobDetail的名字和组："+ jobKey.getName()+", "+ jobKey.getGroup());
        TriggerKey trKey = context.getTrigger().getKey();
        System.out.println("Trigger的名字和组："+ trKey.getName()+ ", "+ trKey.getGroup());

        JobDataMap dDataMap = context.getJobDetail().getJobDataMap();
        String jobMsg = dDataMap.getString("message");
        float jobValue = dDataMap.getFloatValue("mathValue");
        System.out.println("jobMsg:"+ jobMsg+", "+ "jobValue:"+ jobValue);
        JobDataMap tdataMap = context.getTrigger().getJobDataMap();
        String trMsg = tdataMap.getString("message");

        /*
        MergeJobDataMap就是把所有的DataMap合并以后的容器
        如果JobDetail和Trigger有重复的Key，会优先用Trigger的键值对
         */
        JobDataMap dataMap = context.getMergedJobDataMap();
        String msg = dataMap.getString("message");
        System.out.println(msg);

    }

}
