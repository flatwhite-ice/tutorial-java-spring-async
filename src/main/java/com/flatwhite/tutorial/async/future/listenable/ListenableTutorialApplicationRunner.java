package com.flatwhite.tutorial.async.future.listenable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class ListenableTutorialApplicationRunner {

    private ListenableService listenableService;

    public ListenableTutorialApplicationRunner(ListenableService listenableService){
        this.listenableService = listenableService;
    }

    @GetMapping("/listenable")
    public String listenable() throws InterruptedException, ExecutionException {

        log.info("listenable()");
        ListenableFuture<String> f = listenableService.hello();
        f.addCallback(s -> log.info(s), ex -> log.info(ex.getMessage()));
        log.info("exit");
        return f.get();
    }

}
