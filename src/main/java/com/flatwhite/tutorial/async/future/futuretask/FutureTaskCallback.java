package com.flatwhite.tutorial.async.future.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskCallback {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        FutureTask<String> f = new FutureTask<String>(() -> {
            log.info("before thread sleep.");
            Thread.sleep(5000L);
            log.info("Async");
            return "Hello";
        }){

            @Override
            protected void done(){
                super.done();

                try{
                    log.info(get());
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        };

        log.info("futureTask not started yet.");
        es.execute(f);
        log.info("futureTask started.");

        es.shutdown();
        log.info("exit");
        log.info(f.get());;

    }

}
