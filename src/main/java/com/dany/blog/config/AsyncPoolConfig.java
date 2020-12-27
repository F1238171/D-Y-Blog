package com.dany.blog.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * springboot线程池简单配置
 */
@Slf4j
public class AsyncPoolConfig implements AsyncConfigurer {
    /**
     * @return：返回一个线程池，配置了这个线程池就会覆盖springboot自带的线程池
     */
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        //创建线程池
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数 默认值是1
        threadPoolTaskExecutor.setCorePoolSize(10);
        //线程的最大数量，当核心线程使用完了，而且缓冲队列满了 就会创建其它线程
        threadPoolTaskExecutor.setMaxPoolSize(15);
        //缓冲队列的个数 :队列作为一个缓冲的工具，
        //当没有足够的线程去处理任务时，可以将任务放进队列中，以队列先进先出的特性来执行工作任务
        threadPoolTaskExecutor.setQueueCapacity(20);
        //非核心线程，如果空闲超过100秒就被回收
        threadPoolTaskExecutor.setKeepAliveSeconds(100);
        //设置线程的前缀名称
        threadPoolTaskExecutor.setThreadNamePrefix("cn_edu");
        //用来设置线程池关闭的时候等待所有任务都完成(可以设置时间)
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //设置上面的时间
        threadPoolTaskExecutor.setAwaitTerminationSeconds(100);

        //拒绝策略:线程池都忙不过来的时候，可以适当选择拒绝
        /**
         *  ThreadPoolExecutor.AbortPolicy();//默认，队列满了丢任务抛出异常
         * ThreadPoolExecutor.DiscardPolicy();//队列满了丢任务不异常
         * ThreadPoolExecutor.DiscardOldestPolicy();//将最早进入队列的任务删，之后再尝试加入队列
         * ThreadPoolExecutor.CallerRunsPolicy();//如果添加到线程池失败，那么主线程会自己去执行该任务
         */
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //初始化线程池
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

    /**
     * @return:异步任务的异常处理
     * 处理没有返回值的异步处理
     * 有返回值的，会返回抛出的异常，自己去处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        /**
         * @param throwable:异常信息
         * @param method:抛出异常的异步方法
         * @param objects：传递给线程异常处理的参数，（开发没用到）
         */
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
//            log.info("异常：{}，方法：{}，参数：",throwable.getMessage(),method.getName(),objects);
//            log.error(throwable.getMessage());

            throwable.printStackTrace();
        }
    }
}