package net.lishaoy.serializabledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import net.lishaoy.serializabledemo.entity.Student;
import net.lishaoy.serializabledemo.entity.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrgJsonActivity extends AppCompatActivity {

    private static final String TAG = "OrgJsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_json);
        try {
            createJson();
            parseJson();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createJson() throws JSONException, IOException {
        File file = new File(getFilesDir(), "orgJson.json");
        JSONObject student = new JSONObject();
        student.put("name","lsy");
        student.put("age", 66);
        JSONObject course = new JSONObject();
        course.put("name","数学");
        course.put("score",66);
        student.put("course", course);
        JSONArray courses = new JSONArray();
        courses.put(0, course);
        student.put("courses",courses);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(student.toString().getBytes());
        outputStream.close();
        Log.i(TAG, "createJson: " + student.toString());
    }

    private void parseJson() throws IOException, JSONException {
        File file = new File(getFilesDir(), "orgJson.json");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }
        inputStream.close();
        streamReader.close();
        reader.close();

        Student student = new Student();
        JSONObject jsonObject = new JSONObject(stringBuffer.toString());
        String name = jsonObject.optString("name", "lsy");
        int age = jsonObject.optInt("age", 66);
        student.setName(name);
        student.setAge(age);

        JSONArray courses = jsonObject.optJSONArray("courses");
        for (int i = 0; i < courses.length(); i++) {
            JSONObject course = courses.getJSONObject(i);
            Course course1 = new Course();
            course1.setName(course.optString("name",""));
            course1.setScore((float) course.optDouble("score", 0));
            student.addCourse(course1);
        }

        Log.i(TAG, "parseJson: " + student);

    }
}