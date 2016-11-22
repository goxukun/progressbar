package com.xukun.forever.xmjd.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.xukun.forever.xmjd.base.BasePager;

import java.util.ArrayList;

/**
 * Created by forever on 2016/11/21.
 */

public class MyPagerAdapter extends PagerAdapter{

    ArrayList<BasePager> viewPagers = new ArrayList<>();

    public MyPagerAdapter(ArrayList<BasePager> viewPagers){
        this.viewPagers = viewPagers;
    }

    @Override
    public int getCount() {
        return viewPagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewPagers.get(position).getRootView();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
