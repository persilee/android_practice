package net.lishaoy.serializabledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import net.lishaoy.serializabledemo.entity.Course;
import net.lishaoy.serializabledemo.entity.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "GsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        try {
            createGson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createGson() throws IOException {
        Student student = new Student(1,"lsy", 66);
        student.addCourse(new Course("英语",66));

        Gson gson = new Gson();
        File file = new File(getFilesDir(), "gsonStudent.json");
        OutputStream outputStream = new FileOutputStream(file);
        gson.toJson(
                student,
                new TypeToken<Student>(){}.getType(),
                new JsonWriter(new OutputStreamWriter(outputStream, "utf-8"))
                );
        String json = gson.toJson(student);

        Log.i(TAG, "createGson: json " + json);

        Student student1 = gson.fromJson(new JsonReader(new InputStreamReader(new FileInputStream(file))),new TypeToken<Student>(){}.getType());
        Log.i(TAG, "createGson: " + student1);

        Log.i(TAG, "createGson: json1" + gson.fromJson(json, Student.class));
    }
}