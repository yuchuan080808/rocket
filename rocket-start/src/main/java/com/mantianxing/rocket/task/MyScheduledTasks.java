package com.mantianxing.rocket.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTasks {

    // 每隔5秒执行一次
    @Scheduled(fixedRate = 5000)
    public void performTask() {
        System.out.println("定时任务执行: " + System.currentTimeMillis() + ", 5s 执行一次");
    }

    // 每天上午10点执行
    @Scheduled(cron = "0 0 10 * * ?")
    public void performDailyTask() {
        System.out.println("每天上午10点执行的任务");
    }

    // 延迟1秒后第一次执行，之后每2秒执行一次
    @Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void performTaskWithInitialDelay() {
        //System.out.println("延迟1秒后第一次执行，之后每2秒执行一次");
    }
}
