package com.flatwhite.tutorial.async.future.callbackfuturetask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CallbackFutureTaskSuccessExceptionCallbackTutorial {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        SuccessCallback sc = result -> {
            log.info("result : {}", result);
        };

        ExceptionCallback ec = exception -> {
            log.error("error : {}", exception.getMessage());
        };

        CallbackFutureTaskSuccessExceptionCallback f = new CallbackFutureTaskSuccessExceptionCallback(() -> {
            log.info("before thread sleep.");
            Thread.sleep(5000L);

            //if(1 == 1) throw new RuntimeException("async error occured.");

            log.info("Async");
            return "Hello";
        }, sc, ec);

        log.info("futureTask not started yet.");
        es.execute(f);
        log.info("futureTask started.");

        es.shutdown();
        log.info("exit");

        //log.info(f.get());


    }

}
