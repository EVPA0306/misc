package com.evpa.cass.rx;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxThreading {

    private final static Logger logger = LoggerFactory.getLogger(RxThreading.class);

    public static void main(String[] args) throws InterruptedException {
        Flowable.range(1,5)
                .map(i -> i * 10)
                .map(i -> {
                    logger.info("map({})",i);
                    return i.toString();
                })
                .subscribe(logger::info);
        Thread.sleep(1000);
    }
}
