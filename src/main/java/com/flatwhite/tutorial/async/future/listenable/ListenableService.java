package com.flatwhite.tutorial.async.future.listenable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Service
public class ListenableService {

    @Async("tpte")
    public ListenableFuture<String> hello() throws InterruptedException {
        log.info("hello()");
        Thread.sleep(1000L);
        return new AsyncResult<>("hello");
    }

}
