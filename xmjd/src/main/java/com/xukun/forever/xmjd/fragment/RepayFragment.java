package com.xukun.forever.xmjd.fragment;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.xukun.forever.xmjd.base.BasePager;

/**
 * Created by forever on 2016/11/21.
 */

public class RepayFragment extends BasePager {

    private TextView textView;

    public RepayFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setText("RepayFragment");
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public void initData() {

    }
}
