package com.xukun.forever.jintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_get;
    private Button btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get = (Button) findViewById(R.id.btn_get);
        btn_set = (Button) findViewById(R.id.btn_set);

        btn_get.setOnClickListener(this);
        btn_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_get:
                Log.i("tag", "点击Get按钮");
                Toast.makeText(this, getStrignFromJNI(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_set:
                Log.i("tag", "点击Set按钮");
                setStringToJNI("Hello C! 我是一只来自Java世界的Cat，喵~~~");
                break;
        }
    }

    /**
     * 声明的get方法
     * -作用从本地方法返回一个 String
     * @return String
     */
    public native String getStrignFromJNI();

    /**
     * 声明一个set方法
     * -作用向本地方法发送一个String
     * @return String
     */
    public native void setStringToJNI(String str);

    /**
     * 动态加载本地数据库
     */
    static {
        System.loadLibrary("jni_test");
    }
}
