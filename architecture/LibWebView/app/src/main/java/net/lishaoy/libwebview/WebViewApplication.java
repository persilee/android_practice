package net.lishaoy.libwebview;

import com.kingja.loadsir.core.LoadSir;

import net.lishaoy.base.BaseApplication;
import net.lishaoy.base.loadsir.CustomCallback;
import net.lishaoy.base.loadsir.EmptyCallback;
import net.lishaoy.base.loadsir.ErrorCallback;
import net.lishaoy.base.loadsir.LoadingCallback;
import net.lishaoy.base.loadsir.TimeoutCallback;

public class WebViewApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
