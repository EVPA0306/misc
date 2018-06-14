package com.evpa.cass.rx;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.Calendar;
import java.util.Date;


public class HelloReactX {
    public static void main(String[] args) throws InterruptedException {



        Flowable.just("Hello ReactX Flowable").subscribe(System.out::println);

        Observable.just("Hello ReactX Observable").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);

        /*Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        }).subscribeOn(Schedulers.io())
        .observeOn(Schedulers.single())
                .doOnError(Throwable::printStackTrace)
        .subscribe(System.out::println,Throwable::printStackTrace);

        Thread.sleep(2000);*/
    }
}
