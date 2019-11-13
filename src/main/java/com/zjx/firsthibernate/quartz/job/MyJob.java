package com.zjx.firsthibernate.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("测试一下"+new Date().getTime());
    }

    public void execute() throws JobExecutionException {

        System.out.println("test:数据改变，无参数："+new Date().getTime());
    }
}
