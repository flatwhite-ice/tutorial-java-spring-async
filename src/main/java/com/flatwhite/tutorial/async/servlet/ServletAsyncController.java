package com.flatwhite.tutorial.async.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@Slf4j
@RestController
public class ServletAsyncController {


    @GetMapping("/callable/async")
    public Callable<String> callableAsync() {
        log.info("callable()");
        return () -> {
            log.info("async");
            Thread.sleep(2000L);
            return "hello async";
        };
    }


    @GetMapping("/callable/sync")
    public String callableSync() throws InterruptedException {
        log.info("callable()");
        Thread.sleep(2000L);
        return "hello sync";

    }

}
