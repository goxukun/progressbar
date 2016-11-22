package com.xukun.forever.xmjd.base;


import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by forever on 2016/11/21.
 */

public abstract class BasePager {

    public Context mContext;
    private final View view;

    public BasePager(Context context){
        this.mContext = context;
        view = initView();

        initData();
    }

    /**
     * 显示布局界面
     * @return 布局View
     */
    public abstract View initView();

    /**
     * 加载数据
     * @
     */
    public abstract void initData();

    /**
     * 因为viewpager中需要添加的是界面的view对象，所以在每个界面中创建getRootView获取每个界面的view对象，因为
     * 每个界面中都有相同的方法，相同方法抽取到父类
     * @return
     */
    public View getRootView(){
        return view;
    }

}
