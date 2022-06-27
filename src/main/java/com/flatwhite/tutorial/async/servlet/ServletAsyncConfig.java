package com.flatwhite.tutorial.async.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class ServletAsyncConfig  implements AsyncConfigurer {

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {

            // 워커 스레드 풀 설정
            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
                ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
                te.setCorePoolSize(100);
                te.setQueueCapacity(50);
                te.setMaxPoolSize(200);
                te.setThreadNamePrefix("workThread");
                te.initialize();
                configurer.setTaskExecutor(te);
            }
        };
    }

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//                configurer.setTaskExecutor(getTaskExecutor());
//            }
//        };
//    }
//
//    @Bean
//    public ConcurrentTaskExecutor getTaskExecutor() {
//        return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(5));
//    }
}
