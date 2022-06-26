package com.flatwhite.tutorial.async.future.callbackfuturetask;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallbackFutureTask extends FutureTask<String> {

    SuccessCallback sc;

    public CallbackFutureTask(Callable<String> callable, SuccessCallback sc) {
        super(callable);
        this.sc = Objects.requireNonNull(sc);
    }

    @Override
    protected void done(){
        super.done();

        try{
            this.sc.onSuccess(get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
