package net.lishaoy.base;

import android.app.Application;

public class BaseApplication extends Application {

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
