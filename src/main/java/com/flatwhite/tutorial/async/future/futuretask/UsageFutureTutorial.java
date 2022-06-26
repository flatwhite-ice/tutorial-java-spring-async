package com.flatwhite.tutorial.async.future.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class UsageFutureTutorial {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        FutureTask<String> f = new FutureTask<String>(() -> {
            log.info("before thread sleep.");
            Thread.sleep(5000L);
            log.info("Async");
            return "Hello";

        });

        log.info("futureTask not started yet.");
        es.execute(f);
        log.info("futureTask started.");

        log.info(String.valueOf(f.isDone()));
        Thread.sleep(5000L);
        log.info("exit");
        log.info(String.valueOf(f.isDone()));
        log.info(f.get());;

    }

}
