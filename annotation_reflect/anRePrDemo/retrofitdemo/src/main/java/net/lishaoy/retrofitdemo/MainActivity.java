package net.lishaoy.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.lishaoy.retrofitdemo.api.WeatherApi;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WeatherApi weatherApi;
    private TextView textView;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LsyRetrofit lsyRetrofit = new LsyRetrofit.Builder().baseUrl("https://restapi.amap.com").build();
        weatherApi = lsyRetrofit.create(WeatherApi.class);

        textView = findViewById(R.id.text_view);
    }

    public void get(View view) {
        okhttp3.Call call = weatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                s = response.body().string();
                Log.i(TAG, "onResponse: " + s);

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Get: " + s);
                    }
                });

                response.close();
            }
        });
    }

    public void post(View view) {
        Call call = weatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                s = response.body().string();
                Log.i(TAG, "onResponse: " + s);

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Post: " + s);
                    }
                });

                response.close();
            }
        });
    }
}
