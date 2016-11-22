package com.xukun.forever.xmjd.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xukun.forever.xmjd.R;

/**
 * Created by forever on 2016/11/21.
 */

public class MyListView extends BaseAdapter{

    private Context mContext;
    public MyListView(Context context){
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(mContext, R.layout.item_more,null);
        }
        return view;
    }
}
