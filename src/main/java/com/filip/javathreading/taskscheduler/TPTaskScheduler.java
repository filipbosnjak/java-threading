package com.filip.javathreading.taskscheduler;

import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class TPTaskScheduler {
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new TaskSchedulerBuilder()
                .poolSize(5)
                .threadNamePrefix("filip-thread")
                .build();
    }
}
