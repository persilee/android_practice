package net.lishaoy.userxjava;

import java.io.InputStream;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public class UseRxJava {

    public static void main(String[] args) {
        Disposable disposable;
        // hook 钩子函数
        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
            @Override
            public Observable apply(Observable observable) throws Throwable {
                System.out.println(observable + " 你想买🍊 ？");
                return observable;
            }
        });
        Observable.just("🍊")
                .map(new Function<String, Object>() {
                    @Override
                    public Object apply(String s) throws Throwable {
                        return "lsy 买了 " + s;
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Throwable {
                        System.out.println(o);
                    }
                });

        // 创建 Observable 被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("🍊 到货了！");
                emitter.onNext("大家可以来买 🍊 了！");
                emitter.onError(new Throwable("🍊 又卖完了！"));
                emitter.onNext("WOW！🍊 卖光了");
                emitter.onComplete();
                emitter.onComplete();
                emitter.onNext("🍊 加急进货中...");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Throwable {
                return s + " map ";
            }
        });

        // 创建 Observer 观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe:" + d.isDisposed());
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext:" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        // 关联订阅关系
        observable.subscribe(observer);
    }

}