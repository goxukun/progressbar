package com.xukun.forever.xmjd.fragment;


import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.xukun.forever.xmjd.R;
import com.xukun.forever.xmjd.base.BasePager;
import com.xukun.forever.xmjd.view.MyListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by forever on 2016/11/21.
 */

public class MoreFragment extends BasePager {

    @InjectView(R.id.lv_more)
    ListView lvMore;
    private TextView textView;
    private MyListView mtListView;

    public MoreFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.viewpager_more, null);
        ButterKnife.inject(this,view);
        return view;
    }

    @Override
    public void initData() {
        if(mtListView == null){
            mtListView = new MyListView(mContext);
            lvMore.setAdapter(mtListView);
        }else{
            mtListView.notifyDataSetChanged();
        }
    }
}
