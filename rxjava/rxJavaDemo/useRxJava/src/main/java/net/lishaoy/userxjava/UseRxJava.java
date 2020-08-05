package net.lishaoy.userxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class UseRxJava {

    public static void main(String[] args) {
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