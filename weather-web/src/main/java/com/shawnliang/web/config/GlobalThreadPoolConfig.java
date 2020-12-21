package com.shawnliang.web.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/8
 */
@Configuration
public class GlobalThreadPoolConfig {

    @Bean("globalExecutor")
    public Executor globalExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(5);
        // 配置最大线程数
        executor.setMaxPoolSize(20);
        // 配置队列大小
        executor.setQueueCapacity(1024);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("global-");

        // 设置拒绝策略：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }

    @Bean("bizExecutor")
    public ThreadPoolTaskExecutor bizExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(20);
        // 配置最大线程数
        executor.setMaxPoolSize(40);
        // 配置队列大小
        executor.setQueueCapacity(50);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("global-");

        // 设置拒绝策略：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
        // 执行初始化
        executor.initialize();

        return executor;
    }
}
