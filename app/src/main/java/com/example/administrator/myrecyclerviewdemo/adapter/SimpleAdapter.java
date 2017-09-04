package com.example.administrator.myrecyclerviewdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.myrecyclerviewdemo.R;
import com.example.administrator.myrecyclerviewdemo.bean.SimpleBean;

import java.util.List;

/**
 * Created by LiBing
 * on 2017/9/4 0004
 * describe:
 */

public class SimpleAdapter extends BaseQuickAdapter<SimpleBean, BaseViewHolder> {


    public SimpleAdapter(@LayoutRes int layoutResId, @Nullable List<SimpleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SimpleBean item) {
        helper.setText(R.id.title, item.getTitle())
                .setText(R.id.content, item.getContent())
                .addOnClickListener(R.id.title)
                .addOnLongClickListener(R.id.iv);

        Glide.with(mContext).load(item.getUrl()).crossFade().into((ImageView) helper.getView(R.id.iv));

    }
}
