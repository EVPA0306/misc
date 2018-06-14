package com.evpa.cass.rx;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Based on article
 * Going Reactive with Eclipse Vert.x and RxJava
 * Building responsive, scalable apps with one of the most popular reactive libraries
 */
public class RxHello {

    private static final Logger logger = LoggerFactory.getLogger(RxHello.class);

    public static void main(String[] args) {
        Single.just(1)
                .map(i -> i * 10)
                .map(Object::toString)
                .subscribe((Consumer<String>) logger::info);

        Maybe.just("Something")
                .subscribe(logger::info);

        Maybe.never()
                .subscribe(o -> logger.info("Something is here..."));

        Completable.complete()
                .subscribe(() -> logger.info("Completed"));

        Flowable.just("foo","bar","baz")
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .subscribe(logger::info);

        List<String> data = Arrays.asList("foo","bar","baz");
        Random random = new Random();

        Observable<String> source = Observable.create(subscriber -> {
            data.forEach(s -> {
                if(random.nextInt(6) == 0) {
                    subscriber.onError(new RuntimeException("Bad luck!"));
                }
                subscriber.onNext(s);
            });
            subscriber.onComplete();
        });

        for (int i = 0; i < 10; i++) {
            logger.info("=================");
            source.retry(5)
                    .subscribe(
                    next -> logger.info("Next: {}",next),
                    error -> logger.error("Whooops"),
                    () -> logger.info("Done")
            );
        }
    }
}
