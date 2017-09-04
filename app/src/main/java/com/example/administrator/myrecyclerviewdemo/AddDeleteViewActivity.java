package com.example.administrator.myrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.myrecyclerviewdemo.adapter.SimpleAdapter;
import com.example.administrator.myrecyclerviewdemo.bean.SimpleBean;

import java.util.ArrayList;

public class AddDeleteViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<SimpleBean> mList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete_view);
        initData();
        initRecyclerView();
        initHeadFootView();
    }

    private void initHeadFootView() {
        View headerView = getHeaderView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0);
            }
        });
        mAdapter.addHeaderView(headerView);

        View footerView = getFooterView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0);
            }
        });
        mAdapter.addFooterView(footerView, 0);
    }

    private View getHeaderView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveHeaderListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.removeHeaderView(v);
            }
        };
    }

    private View getFooterView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.footer_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveFooterListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.removeFooterView(v);
            }
        };
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
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter = new SimpleAdapter(R.layout.item_simple, mList);
        mAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mAdapter);
    }
}
