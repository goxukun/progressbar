package com.xukun.forever.xmjd;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.xukun.forever.xmjd.base.BasePager;
import com.xukun.forever.xmjd.fragment.BorrowFragment;
import com.xukun.forever.xmjd.fragment.MoreFragment;
import com.xukun.forever.xmjd.fragment.PersonalCenterFragment;
import com.xukun.forever.xmjd.fragment.RepayFragment;
import com.xukun.forever.xmjd.view.MyPagerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.vg_main)
    ViewPager vgMain;
    @InjectView(R.id.rb_borrow)
    RadioButton rbBorrow;
    @InjectView(R.id.rb_repayment)
    RadioButton rbRepayment;
    @InjectView(R.id.rb_personalcenter)
    RadioButton rbPersonalcenter;
    @InjectView(R.id.rb_more)
    RadioButton rbMore;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;

    private ArrayList<BasePager> pagers;
    private MyPagerAdapter mypagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        // 初始化
        initDate();
        initListener();
        
    }

    private void initDate() {
        pagers = new ArrayList<BasePager>();

        pagers.clear();
        pagers.add(new BorrowFragment(getApplicationContext()));
        pagers.add(new RepayFragment(getApplicationContext()));
        pagers.add(new PersonalCenterFragment(getApplicationContext()));
        pagers.add(new MoreFragment(getApplicationContext()));

        // viewpager适配器
        if(mypagerAdapter == null){
            mypagerAdapter = new MyPagerAdapter(pagers);
            vgMain.setAdapter(mypagerAdapter);
        }else{
            mypagerAdapter.notifyDataSetChanged();
        }

    }

    private void initListener(){
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rb_borrow:
                        vgMain.setCurrentItem(0,false);
                        break;
                    case R.id.rb_repayment:
                        vgMain.setCurrentItem(1,false);
                        break;
                    case R.id.rb_personalcenter:
                        vgMain.setCurrentItem(2,false);
                        break;
                    case R.id.rb_more:
                        vgMain.setCurrentItem(3,false);
                        break;
                }
            }
        });
    }
}
