package com.flatwhite.tutorial.async.future.listenable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public ThreadPoolTaskExecutor tpte(){
        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
        tpte.setCorePoolSize(10);
        tpte.setQueueCapacity(50);
        tpte.setMaxPoolSize(100);
        tpte.setThreadNamePrefix("tpte");
        return tpte;
    }



}
