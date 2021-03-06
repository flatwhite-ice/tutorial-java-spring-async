package com.flatwhite.tutorial.async.future.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CallableFutureIsDone {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        Future<String> f = es.submit(() -> {
            log.info("before thread sleep.");
            Thread.sleep(5000L);
            log.info("Async");
            return "Hello";

        });

        log.debug("started..");
        log.info(String.valueOf(f.isDone()));
        Thread.sleep(5000L);
        log.info("exit");
        log.info(String.valueOf(f.isDone()));
        log.info(f.get());

    }

}
