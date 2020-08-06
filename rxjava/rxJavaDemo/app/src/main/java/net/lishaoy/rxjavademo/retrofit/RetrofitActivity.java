package net.lishaoy.rxjavademo.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import net.lishaoy.rxjavademo.R;
import net.lishaoy.rxjavademo.retrofit.api.Api;
import net.lishaoy.rxjavademo.retrofit.api.HttpClient;
import net.lishaoy.rxjavademo.retrofit.bean.ProjectBean;
import net.lishaoy.rxjavademo.retrofit.bean.ProjectItem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    private Api api;
    private TextView textView;
    private String itemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textView = findViewById(R.id.text_view);

        api = HttpClient.getRetrofit().create(Api.class); // 生成 api
        getProjectItemData();
        getItemData();
    }

    // 查询项目分类数据
    @SuppressLint("CheckResult")
    public void getProject(View view) {
        api.getProject()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectBean>() {
                    @Override
                    public void accept(ProjectBean projectBean) throws Exception {
                        textView.setText(projectBean.toString());
                    }
                });
    }

    // 查询项目列表数据，项目列表数据需要根据项目分类数据的 id 进行查询
    // 且使用 rxbinding 增加防抖功能
    @SuppressLint("CheckResult")
    public void getProjectItemData() {
        Button button = findViewById(R.id.get_item_button_fd);
        RxView.clicks(button) // 设置防抖的 view
                .throttleFirst(2600, TimeUnit.MILLISECONDS) // 设置在 2.6 秒内只响应一次点击事件
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        api.getProject() // 查询项目分类数据(返回的是 Observable 被观察者)
                                .subscribeOn(Schedulers.io()) // 给上面的代码分配工作线程
                                .observeOn(AndroidSchedulers.mainThread()) // 给下面的代码分配主线程
                                .subscribe(new Consumer<ProjectBean>() { // 订阅并创建观察者
                                    @Override
                                    public void accept(final ProjectBean projectBean) throws Exception {
                                        for (ProjectBean.DataBean bean: projectBean.getData()) {
                                            api.getProjectItem(1, bean.getId()) // 根据项目分类数据的 id 查询项目列表数据(返回的是 Observable 被观察者)
                                                    .subscribeOn(Schedulers.io()) // 给上面的代码分配工作线程
                                                    .observeOn(AndroidSchedulers.mainThread()) // 给下面的代码分配主线程
                                                    .subscribe(new Consumer<ProjectItem>() { // 订阅并创建观察者
                                                        @Override
                                                        public void accept(ProjectItem projectItem) throws Exception {
                                                            Log.d(TAG, "accept: " + projectItem);
                                                            textView.setText(projectItem.toString()); // 进行 UI 操作
                                                        }
                                                    });
                                        }
                                    }
                                });
                    }
                });
    }


    // 查询项目列表数据，使用 flatMap 操作符，解决网络嵌套问题
    @SuppressLint("CheckResult")
    public void getItemData(){
        Button button = findViewById(R.id.get_item_button);
        RxView.clicks(button) // 设置防抖的 view
                .throttleFirst(2600, TimeUnit.MILLISECONDS) // 设置在 2.6 秒内只响应一次点击事件
                .observeOn(Schedulers.io()) // 给下面的代码分配工作线程
                .flatMap(new Function<Object, ObservableSource<ProjectBean>>() {
                    @Override
                    public ObservableSource<ProjectBean> apply(Object o) throws Exception {
                        return api.getProject(); // 查询项目分类数据，并且把数据流向下游
                    }
                })
                .flatMap(new Function<ProjectBean, ObservableSource<ProjectBean.DataBean>>() {
                    @Override
                    public ObservableSource<ProjectBean.DataBean> apply(ProjectBean projectBean) throws Exception {
                        return Observable.fromIterable(projectBean.getData()); // 根据上游流过来的数据，迭代出每个 ProjectItem 项目列表数据，并且流向下游
                    }
                })
                .flatMap(new Function<ProjectBean.DataBean, ObservableSource<ProjectItem>>() {
                    @Override
                    public ObservableSource<ProjectItem> apply(ProjectBean.DataBean dataBean) throws Exception {
                        return api.getProjectItem(1, dataBean.getId()); // 根据上游流过来的数据，查询每个列表数据，并且流向下游
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectItem>() {
                    @Override
                    public void accept(ProjectItem projectItem) throws Exception {
                        itemData += projectItem.toString() + "\n ================================================ \n";
                        textView.setText(itemData); // 根据上游流过来的数据，进行 UI 操作
                    }
                });
    }
}