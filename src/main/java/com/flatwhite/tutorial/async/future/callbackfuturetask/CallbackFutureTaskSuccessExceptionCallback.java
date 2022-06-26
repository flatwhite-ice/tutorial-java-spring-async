package com.flatwhite.tutorial.async.future.callbackfuturetask;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CallbackFutureTaskSuccessExceptionCallback extends FutureTask<String> {

    SuccessCallback sc;

    ExceptionCallback ec;


    public CallbackFutureTaskSuccessExceptionCallback(Callable<String> callable
            , SuccessCallback sc
            , ExceptionCallback ec) {
        super(callable);
        this.sc = Objects.requireNonNull(sc);
        this.ec = Objects.requireNonNull(ec);
    }

    @Override
    protected void done(){
        super.done();

        try{
            this.sc.onSuccess(get());

            //InterruptedException : task stop message
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            //wrapped Exception
            ec.onError(e.getCause());
        }
    }

}
