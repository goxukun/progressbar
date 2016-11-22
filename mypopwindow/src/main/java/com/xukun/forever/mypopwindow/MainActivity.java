package com.xukun.forever.mypopwindow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context mContent;

    private Button btn_main;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = this;

        btn_main = (Button) findViewById(R.id.btn_main);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopwindow();
            }
        });

    }

    /**
     * 展示Popwindow
     */
    private void showPopwindow() {
        // 一个自定义的布局，作为显示的内容
        View myPopwindow = View.inflate(mContent, R.layout.popwindow1, null);

        button1 = (Button) myPopwindow.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContent,"button is pressed",Toast.LENGTH_SHORT).show();
            }
        });

        PopupWindow popupWindow = new PopupWindow(myPopwindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        popupWindow.setAnimationStyle(R.style.popwin_anim_style);

        // 设置好参数后在show
        popupWindow.showAsDropDown(btn_main,5,-5);
    }
}
