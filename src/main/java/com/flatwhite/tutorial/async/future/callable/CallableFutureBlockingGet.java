package com.flatwhite.tutorial.async.future.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CallableFutureBlockingGet {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        Future<String> f = es.submit(() -> {
            log.info("before thread sleep.");
            Thread.sleep(5000L);
            log.info("Async");
            return "Hello";

        });

        log.debug("started..");
        log.info(f.get());
        log.info("exit");

    }

}
