package net.lishaoy.serializabledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

public class ParcelActivity extends AppCompatActivity {

    private static final String TAG = "ParcelActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);

        Intent intent = getIntent();
        Parcelable course = intent.getParcelableExtra("course");
        Log.i(TAG, "onCreate: " + course.toString());
    }
}