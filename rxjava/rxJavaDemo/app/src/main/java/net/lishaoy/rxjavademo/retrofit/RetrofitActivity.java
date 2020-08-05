package net.lishaoy.rxjavademo.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import net.lishaoy.rxjavademo.R;
import net.lishaoy.rxjavademo.retrofit.api.Api;
import net.lishaoy.rxjavademo.retrofit.api.HttpClient;
import net.lishaoy.rxjavademo.retrofit.bean.ProjectBean;
import net.lishaoy.rxjavademo.retrofit.bean.ProjectItem;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

        api = HttpClient.getRetrofit().create(Api.class);

        getItemData();
    }


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

    @SuppressLint("CheckResult")
    public void getItemData(){
        Button button = findViewById(R.id.get_item_button);
        RxView.clicks(button)
                .throttleFirst(2600, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .flatMap(new Function<Object, ObservableSource<ProjectBean>>() {
                    @Override
                    public ObservableSource<ProjectBean> apply(Object o) throws Exception {
                        return api.getProject();
                    }
                })
                .flatMap(new Function<ProjectBean, ObservableSource<ProjectBean.DataBean>>() {
                    @Override
                    public ObservableSource<ProjectBean.DataBean> apply(ProjectBean projectBean) throws Exception {
                        return Observable.fromIterable(projectBean.getData());
                    }
                })
                .flatMap(new Function<ProjectBean.DataBean, ObservableSource<ProjectItem>>() {
                    @Override
                    public ObservableSource<ProjectItem> apply(ProjectBean.DataBean dataBean) throws Exception {
                        return api.getProjectItem(1, dataBean.getId());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectItem>() {
                    @Override
                    public void accept(ProjectItem projectItem) throws Exception {
                        itemData += projectItem.toString() + "\n ================================================ \n";
                        textView.setText(itemData);
                    }
                });
    }
}