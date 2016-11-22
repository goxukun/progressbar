package com.xukun.forever.domehttps;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_get)
    Button btnGet;
    @InjectView(R.id.btn_post)
    Button btnPost;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String str = (String)msg.obj;
                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initDate();
    }

    private void initDate() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建一个request
                final Request request = new Request.Builder().url("https://kyfw.12306.cn/otn").build();

                // new call
                Call call = OkHttpClientManager.getInstance().newCall(request);

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("GET_failed:",e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        byte[] string = response.body().bytes();
                        String str = new String(string);
                        Log.e("GET_success:",str);
                    }
                });
            }
        });
    }

}
