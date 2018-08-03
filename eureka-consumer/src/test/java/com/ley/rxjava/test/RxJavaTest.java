package com.ley.rxjava.test;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

public class RxJavaTest {

    @Test
    public void testRxJava(){
        Observable<Integer> observable = Observable.create(observer->{
            try {
                if(!observer.isUnsubscribed()){
                    int i=1;
                    observer.onNext(i);
                    observer.onCompleted();
                }
            }catch (Exception e){
                observer.onError(e);
            }
        });
        observable.subscribe(i->{System.out.println(i);});
    }
}
