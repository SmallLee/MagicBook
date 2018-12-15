package com.example.smalllee.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.List;

public class GsonActivity extends AppCompatActivity {
    private static final String TAG = "GsonActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"dddd",Toast.LENGTH_LONG).show();
//            }
//        });
        RelativeLayout relativeLayout = findViewById(R.id.rl_root);
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//        Gson gson = new GsonBuilder().setVersion(5).create();
//        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PRIVATE).serializeNulls().create();
        // 序列化排除策略
//        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new NameExclusionStrategy()).create();
//        // 反序列化排除策略
//        Gson gson1 = new GsonBuilder().addDeserializationExclusionStrategy(new NameExclusionStrategy()).create();
//        // 反序列化/序列化同时适用
//        Gson gson2 = new GsonBuilder().setExclusionStrategies(new NameExclusionStrategy()).create();
//        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class,new IntTypeAdapter()).create();
        StringSerializer serializer = new StringSerializer();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class,serializer)
                .registerTypeAdapter(String.class,serializer)
                .registerTypeAdapter(Double.class,serializer).create();
        new GsonBuilder().registerTypeAdapterFactory(new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                // 通过对比type，返回对应的TypeAdapter
                return null;
            }
        }).create();
        Double aDouble = gson.fromJson("99.99", double.class);
        Log.d(TAG, "onCreate: " + aDouble);
        // 解析泛型需要使用TypeToken
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        List<String> stringList = gson.fromJson(jsonArray,new TypeToken<List<String>>(){}.getType());
        JsonReader jsonReader = new JsonReader(new StringReader(""));
        String json = "{\"name\":\"怪盗kidou\",\"age\":24}";
        Student student = gson.fromJson(json, Student.class);
//        Log.d(TAG, "student: " + aDouble);
//        Log.d(TAG, "student: " + stringList);
//        Log.d(TAG, "integer-100: " + gson.toJson(100)); // 100
//        Log.d(TAG, "integer: " + gson.fromJson("\"\"", Integer.class)); // -1
        Log.d(TAG, "onCreate: " + gson.toJson(true));
        Log.d(TAG, "onCreate: " + gson.toJson(2));
        Log.d(TAG, "onCreate: " + gson.toJson(3.0));
        System.currentTimeMillis();
        SystemClock.uptimeMillis();
        SystemClock.elapsedRealtime();
        try{
            // 事务代码
        }catch (Exception e) {
            // 手动回滚事务
        }
    }
}
