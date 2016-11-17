package com.xukun.forever.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by forever on 2016/11/17.
 */

public class MainActivity extends Activity{

    private ProgressBar pb;

    private Handler mHandle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    pb.setVisibility(View.GONE);
                    Thread.currentThread().interrupt();

                    break;
                case  1:
                    if(!Thread.currentThread().isInterrupted()){
                        pb.setProgress(mCount);
                    }
                    break;
            }
        }
    };
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);

        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<= 10;i++){
                    try {
                        mCount = i*10;
                        Thread.sleep(1000);
                        if(i == 10){
                            Message message = new Message();
                            message.what = 0;
                            mHandle.sendMessage(message);
                            break;
                        }else{
                            Message msg=new Message();
                            msg.what=1;
                            mHandle.sendMessage(msg);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mThread.start();

    }
}
