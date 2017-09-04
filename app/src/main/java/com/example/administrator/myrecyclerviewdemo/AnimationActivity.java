package com.example.administrator.myrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.myrecyclerviewdemo.adapter.AnimationAdapter;
import com.example.administrator.myrecyclerviewdemo.bean.SimpleBean;

import java.util.ArrayList;

public class AnimationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<SimpleBean> mList;
    private AnimationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initData();
        initRecyclerView();
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            SimpleBean bean = new SimpleBean();
            bean.setTitle("条目" + i);
            bean.setContent("内容" + i);
            bean.setUrl("http://img5.imgtn.bdimg.com/it/u=1139776033,805074286&fm=27&gp=0.jpg");
            mList.add(bean);
        }
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AnimationAdapter(R.layout.item_simple, mList);

//        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);

        mAdapter.isFirstOnly(false);

        mRecyclerView.setAdapter(mAdapter);
    }
}
